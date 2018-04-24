import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;//������ ��ü���� �����ϱ� ���� ArrayList.
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		//��ü ����
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
		//������ ��� ��û�� ��� �� �ڿ� �߰���Ű��
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		//������ Ż�� ��û�� ������ ��Ͽ��� ���ܽ�Ű��
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		//�ٲ� ���¸� ��� �������鿡�� �˷��ִ� �κ�.
		for (Observer observer : observers) {//������ ����ŭ �ݺ��ؼ� ��� ���������� update���ֱ�
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		//��� �����̼����κ��� ���ŵ� ����ġ�� ������ ��� �������鿡�� �˷��ִ� �޼ҵ� ����
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
