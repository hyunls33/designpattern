
public class SimpleRemoteControl {
	Command slot;
	
	public SimpleRemoteControl() {}
	
	public void setCommand(Command command) {
		//������ ������ ������ ����� �����ϱ� ���� �޼ҵ�.
		//�� �ڵ带 ����ϴ� Ŭ���̾�Ʈ���� ������ ��ư�� ����� �ٲٰ� �ʹٸ� �� �޼ҵ带 �̿��ؼ� �ٲ� �� ����
		slot = command;
	}
	
	public void buttonWasPressed() {
		slot.execute();//��ư�� ������ �� ȣ��Ǵ� �޼ҵ�
	}
}
