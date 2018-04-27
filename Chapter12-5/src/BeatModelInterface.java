
public interface BeatModelInterface {
	/* 컨트롤러에서 모델한테 사용자 입력을 전달할 때 사용할 메소드 */
	public void initialize();//BeatModel의 인스턴스가 만들어질 때 호출되는 메소드
	public void on();//비트 생성기를 켜기 위한 메소드
	public void off();//비트 생성기를 끄기 위한 메소드
	public void setBPM(int bpm);//BPM을 설정하기 위한 메소드. 이 메소드가 호출시 비트수가 바로 변경됨.
	
	/* 뷰와 컨트롤러에서 상태를 알아내거나 옵저버로 등록할 때 사용할 메소드 */
	//옵저버를 매 박자마다 연락 받을 옵저버와 BPM이 바뀔때만 연락받을 옵저버로 나눔.
	public int getBPM();//현재 BPM값 리턴. 비트 생성기가 꺼져 있으면 o를 리턴.
	public void registerObserver(BeatObserver o);
	public void removeObserver(BeatObserver o);
	public void registerObserver(BPMObserver o);
	public void removeObserver(BPMObserver o);
}
