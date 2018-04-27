
public interface BeatModelInterface {
	/* ��Ʈ�ѷ����� ������ ����� �Է��� ������ �� ����� �޼ҵ� */
	public void initialize();//BeatModel�� �ν��Ͻ��� ������� �� ȣ��Ǵ� �޼ҵ�
	public void on();//��Ʈ �����⸦ �ѱ� ���� �޼ҵ�
	public void off();//��Ʈ �����⸦ ���� ���� �޼ҵ�
	public void setBPM(int bpm);//BPM�� �����ϱ� ���� �޼ҵ�. �� �޼ҵ尡 ȣ��� ��Ʈ���� �ٷ� �����.
	
	/* ��� ��Ʈ�ѷ����� ���¸� �˾Ƴ��ų� �������� ����� �� ����� �޼ҵ� */
	//�������� �� ���ڸ��� ���� ���� �������� BPM�� �ٲ𶧸� �������� �������� ����.
	public int getBPM();//���� BPM�� ����. ��Ʈ �����Ⱑ ���� ������ o�� ����.
	public void registerObserver(BeatObserver o);
	public void removeObserver(BeatObserver o);
	public void registerObserver(BPMObserver o);
	public void removeObserver(BPMObserver o);
}
