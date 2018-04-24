
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		//옵저버로 등록
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		//update호출 시 기온과 습도 저장
		this.temperature = temperature;
		this.humidity = humidity;
		//변경정보 저장 후 display 호출
		display();
	}
	
	public void display() {
		//display에서는 가장 최근에 얻은 기온과 습도 출력
		System.out.println("Current conditions : "+temperature+"F degrees and "+humidity+"% humidity");
	}
}
