
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {//beat�� �ƴ϶� heart�� ����
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));//�信 �����ϱ� ���� ����ͷ� ���α�
        view.createView();
        view.createControls();
        //�޴��� �ʿ� ������ ��Ȱ��ȭ
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



