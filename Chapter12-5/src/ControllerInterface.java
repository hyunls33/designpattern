
public interface ControllerInterface {
	//�信�� ��Ʈ�ѷ��� ���� ȣ���� ��� �������̽��� �������
	public void start();//���� ���� �޼ҵ�
	public void stop();//���� �ߴ� �޼ҵ�
	public void increaseBPM();//�� ������ ����
	public void decreaseBPM();//�� ������ ����
	public void setBPM(int bpm);//�д� ��Ʈ���� ������ �����ϴ� �޼ҵ�
}
