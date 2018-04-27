
public class BeatController implements ControllerInterface {
	//컨트롤러는 MVC에서 view와 model에 모두 맞닿아 있으면서 그 둘을 이어주는 기능 제공
	BeatModelInterface model;
	DJView view;
	
	public BeatController(BeatModelInterface model) {
		//컨트롤러의 생성자에는 모델이 인자로 전달되며, 생성자에서 뷰도 생성해야 함
		this.model = model;
		view = new DJView(this, model);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}

	@Override
	public void start() {
		//사용자 인터페이스 메뉴에서 start를 선택하면 컨트롤러에서는 모델의 on()메소드를 호출하고,
		//사용자 인터페이스 메뉴에서 start항목을 비활성 상태로, stop항목은 활성상태로 바꿔야 함
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	@Override
	public void stop() {
		//메뉴의 stop항목이 선택되면 모델의 off()메소드를 호출한 다음 stop항목은 비활성 상태로,
		//start항목은 활성상태로 바꿔야 함
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

	@Override
	public void increaseBPM() {
		//사용자가 >>버튼을 클릭하면 컨트롤러에서는 모델로부터 현재 BPM을 알아내고 거기에 1을 더한 뒤 BPM값을 새로 설정
		int bpm = model.getBPM();
		model.setBPM(bpm+1);
	}

	@Override
	public void decreaseBPM() {
		//현재 BPM에서 1을 뺸 값으로 BPM을 새로 설정
		int bpm = model.getBPM();
		model.setBPM(bpm-1);
	}

	@Override
	public void setBPM(int bpm) {
		//사용자가 임의의 BPM값을 설정한 경우 모델에 바로 연락해서 새로운 BPM값을 설정해 줌 
		model.setBPM(bpm);
	}

}
