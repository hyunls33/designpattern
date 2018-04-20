import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;//옵저버 객체들을 저장하기 위한 ArrayList.
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		//객체 생성
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
		//옵저버 등록 신청시 목록 맨 뒤에 추가시키기
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		//옵저버 탈퇴 신청시 옵저버 목록에서 제외시키기
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		//바뀐 상태를 모든 옵저버들에게 알려주는 부분.
		for (Observer observer : observers) {//옵저버 수만큼 반복해서 모든 옵저버들을 update해주기
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		//기상 스테이션으로부터 갱신된 측정치를 받으면 모든 옵저버들에게 알려주는 메소드 실행
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
