
public class BeatController implements ControllerInterface {
	//��Ʈ�ѷ��� MVC���� view�� model�� ��� �´�� �����鼭 �� ���� �̾��ִ� ��� ����
	BeatModelInterface model;
	DJView view;
	
	public BeatController(BeatModelInterface model) {
		//��Ʈ�ѷ��� �����ڿ��� ���� ���ڷ� ���޵Ǹ�, �����ڿ��� �䵵 �����ؾ� ��
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
		//����� �������̽� �޴����� start�� �����ϸ� ��Ʈ�ѷ������� ���� on()�޼ҵ带 ȣ���ϰ�,
		//����� �������̽� �޴����� start�׸��� ��Ȱ�� ���·�, stop�׸��� Ȱ�����·� �ٲ�� ��
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	@Override
	public void stop() {
		//�޴��� stop�׸��� ���õǸ� ���� off()�޼ҵ带 ȣ���� ���� stop�׸��� ��Ȱ�� ���·�,
		//start�׸��� Ȱ�����·� �ٲ�� ��
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

	@Override
	public void increaseBPM() {
		//����ڰ� >>��ư�� Ŭ���ϸ� ��Ʈ�ѷ������� �𵨷κ��� ���� BPM�� �˾Ƴ��� �ű⿡ 1�� ���� �� BPM���� ���� ����
		int bpm = model.getBPM();
		model.setBPM(bpm+1);
	}

	@Override
	public void decreaseBPM() {
		//���� BPM���� 1�� �A ������ BPM�� ���� ����
		int bpm = model.getBPM();
		model.setBPM(bpm-1);
	}

	@Override
	public void setBPM(int bpm) {
		//����ڰ� ������ BPM���� ������ ��� �𵨿� �ٷ� �����ؼ� ���ο� BPM���� ������ �� 
		model.setBPM(bpm);
	}

}
