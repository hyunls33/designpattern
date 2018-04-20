
public interface Subject {
	public void registerObserver(Observer o);//옵저버 등록
	public void removeObserver(Observer o);//옵저버 제거
	public void notifyObservers();//주제 객체의 상태 변경시 옵저버들에게 알리는 메소드
}
