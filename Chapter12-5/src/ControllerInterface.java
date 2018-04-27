
public interface ControllerInterface {
	//뷰에서 컨트롤러에 대해 호출할 모든 인터페이스가 들어있음
	public void start();//연주 시작 메소드
	public void stop();//연주 중단 메소드
	public void increaseBPM();//더 빠르게 연주
	public void decreaseBPM();//더 느리게 연주
	public void setBPM(int bpm);//분당 비트수를 정수로 지정하는 메소드
}
