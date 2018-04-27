
public class HeartAdapter implements BeatModelInterface {//타겟 인터페이스 구현
	HeartModelInterface heart;
 
	public HeartAdapter(HeartModelInterface heart) {
		this.heart = heart;
	}

    public void initialize() {}
  
    public void on() {}
  
    public void off() {}
   
	public int getBPM() {
		//호출 시 HeartModel의 getHeartRate()메소드 호출
		return heart.getHeartRate();
	}
  
    public void setBPM(int bpm) {}//심박수는 설정하지 않도록 함
   
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
