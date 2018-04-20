import java.util.Observable;

public class WeatherData extends Observable {//java에서 제공하는 API로 옵저버 패턴 구성하기.
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {}
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humiditiy, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
