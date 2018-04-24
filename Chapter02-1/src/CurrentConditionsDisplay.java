
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		//�������� ���
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		//updateȣ�� �� ��°� ���� ����
		this.temperature = temperature;
		this.humidity = humidity;
		//�������� ���� �� display ȣ��
		display();
	}
	
	public void display() {
		//display������ ���� �ֱٿ� ���� ��°� ���� ���
		System.out.println("Current conditions : "+temperature+"F degrees and "+humidity+"% humidity");
	}
}
