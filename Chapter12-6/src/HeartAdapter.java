
public class HeartAdapter implements BeatModelInterface {//Ÿ�� �������̽� ����
	HeartModelInterface heart;
 
	public HeartAdapter(HeartModelInterface heart) {
		this.heart = heart;
	}

    public void initialize() {}
  
    public void on() {}
  
    public void off() {}
   
	public int getBPM() {
		//ȣ�� �� HeartModel�� getHeartRate()�޼ҵ� ȣ��
		return heart.getHeartRate();
	}
  
    public void setBPM(int bpm) {}//�ɹڼ��� �������� �ʵ��� ��
   
	public void registerObserver(BeatObserver o) {
		heart.registerObserver(o);
	}
    
	public void removeObserver(BeatObserver o) {
		heart.removeObserver(o);
	}
     
	public void registerObserver(BPMObserver o) {
		heart.registerObserver(o);
	}
  
	public void removeObserver(BPMObserver o) {
		heart.removeObserver(o);
	}
}
