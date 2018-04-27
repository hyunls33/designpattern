import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DJView implements ActionListener, BeatObserver, BPMObserver {
	//뷰에는 모델과 컨트롤러에 대한 레퍼런스가 모두 들어있음
	//컨트롤러에 대한 레퍼런스는 제어용 인터페이스 코드에만 쓰임
	BeatModelInterface model;
	ControllerInterface controller;
	
	//화면 표시용 구성요소 필요
	JFrame viewFrame;
	JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
	
	JFrame controlFrame;
	JPanel controlPanel;
	
	JLabel bpmLabel;
	JTextField bpmTextField;
	JButton setBPMButton;
	JButton increaseBPMButton;
	JButton decreaseBPMButton;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem startMenuItem;
	JMenuItem stopMenuItem;
	
	public DJView(ControllerInterface controller, BeatModelInterface model) {
		//생성자에는 컨트롤러와 모델의 레퍼런스가 전달되며, 두 레퍼런스는 인스턴스 변수에 저장됨
		this.controller = controller;
		this.model = model;
		
		//모델에 옵저버 등록
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
	}
	
	public void createView() {
		//스윙 구성요소를 생성하는 부분
		viewPanel = new JPanel(new GridLayout(1, 2));
		viewFrame = new JFrame("View");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(new Dimension(100, 80));
		bpmOutputLabel = new JLabel("offline",SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
		JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
		bpmPanel.add(bpmOutputLabel);
		viewPanel.add(bpmPanel);
		viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
		viewFrame.pack();
		viewFrame.setVisible(true);
	}

	@Override
	public void updateBPM() {
		//모델 상태가 변경되면 updateBPM() 메소드가 호출욈
		//현재 BPM을 보여주는 부분을 갱신
		//BPM값은 모델에거 물어보면 알 수 있음
		int bpm = model.getBPM();
		if (bpm == 0) {
			bpmOutputLabel.setText("offline");
		} else {
			bpmOutputLabel.setText("current BPM : "+model.getBPM());
		}
	}

	@Override
	public void updateBeat() {
		//모델에서 새로운 박자가 연주될 때 마다 updateBeat() 메소드 호출
		//그러면 박자 표시 막대가 한 번 튕기게 됨
		//beatBar의 값을 100으로 설정하고 그 구성요소에서 막대가 튀는 모습을 애니메이션으로 표시하도록 해주면 됨
		beatBar.setValue(100);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//사용자가 버튼을 클릭했을 때 호출될 메소드
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
			controller.setBPM(bpm);
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
	}

	public void createControls() {
		//스윙 구성요소 생성
		//모든 컨트롤을 생성하고 인터페이스 상에 배치하기 위한 메소드
		//start나 stop 항목 선택시 컨트롤러에 있는 각 항목에 대응되는 메소드가 호출됨
		JFrame.setDefaultLookAndFeelDecorated(true);
		controlFrame = new JFrame("Control");
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setSize(new Dimension(100, 80));
		
		controlPanel = new JPanel(new GridLayout(1, 2));
		
		menuBar = new JMenuBar();
		menu = new JMenu("DJ Control");
		startMenuItem = new JMenuItem("Start");
		menu.add(startMenuItem);
		startMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.start();
			}
		});
		stopMenuItem = new JMenuItem("stop");
		menu.add(stopMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.stop();
				//bpmOutputLabel.setText("offline");
			}
		});
		JMenuItem exit = new JMenuItem("Quit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		menu.add(exit);
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10,40));
        increaseBPMButton = new JButton(">>");
        decreaseBPMButton = new JButton("<<");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);
        
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
	}
	
	/* 메뉴에 있는 start 및 stop을 활성화/비활성화 시키는 메소드. 컨트롤러에서 이 메소드들로 인터페이스를 변경 */
	public void enableStopMenuItem() {
		stopMenuItem.setEnabled(true);
	}
	
	public void disableStopMenuItem() {
		stopMenuItem.setEnabled(false);
	}
	
	public void enableStartMenuItem() {
		startMenuItem.setEnabled(true);
	}
	
	public void disableStartMenuItem() {
		startMenuItem.setEnabled(false);
	}
}
