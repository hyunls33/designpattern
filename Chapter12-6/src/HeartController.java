
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {//beat가 아니라 heart를 받음
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));//뷰에 전달하기 전에 어댑터로 감싸기
        view.createView();
        view.createControls();
        //메뉴는 필요 없으니 비활성화
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



