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
	//�信�� �𵨰� ��Ʈ�ѷ��� ���� ���۷����� ��� �������
	//��Ʈ�ѷ��� ���� ���۷����� ����� �������̽� �ڵ忡�� ����
	BeatModelInterface model;
	ControllerInterface controller;
	
	//ȭ�� ǥ�ÿ� ������� �ʿ�
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
		//�����ڿ��� ��Ʈ�ѷ��� ���� ���۷����� ���޵Ǹ�, �� ���۷����� �ν��Ͻ� ������ �����
		this.controller = controller;
		this.model = model;
		
		//�𵨿� ������ ���
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
	}
	
	public void createView() {
		//���� ������Ҹ� �����ϴ� �κ�
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
		//�� ���°� ����Ǹ� updateBPM() �޼ҵ尡 ȣ���
		//���� BPM�� �����ִ� �κ��� ����
		//BPM���� �𵨿��� ����� �� �� ����
		int bpm = model.getBPM();
		if (bpm == 0) {
			bpmOutputLabel.setText("offline");
		} else {
			bpmOutputLabel.setText("current BPM : "+model.getBPM());
		}
	}

	@Override
	public void updateBeat() {
		//�𵨿��� ���ο� ���ڰ� ���ֵ� �� ���� updateBeat() �޼ҵ� ȣ��
		//�׷��� ���� ǥ�� ���밡 �� �� ƨ��� ��
		//beatBar�� ���� 100���� �����ϰ� �� ������ҿ��� ���밡 Ƣ�� ����� �ִϸ��̼����� ǥ���ϵ��� ���ָ� ��
		beatBar.setValue(100);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//����ڰ� ��ư�� Ŭ������ �� ȣ��� �޼ҵ�
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
		//���� ������� ����
		//��� ��Ʈ���� �����ϰ� �������̽� �� ��ġ�ϱ� ���� �޼ҵ�
		//start�� stop �׸� ���ý� ��Ʈ�ѷ��� �ִ� �� �׸� �����Ǵ� �޼ҵ尡 ȣ���
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
	
	/* �޴��� �ִ� start �� stop�� Ȱ��ȭ/��Ȱ��ȭ ��Ű�� �޼ҵ�. ��Ʈ�ѷ����� �� �޼ҵ��� �������̽��� ���� */
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
