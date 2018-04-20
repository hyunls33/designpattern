
public class CeilingFan {
	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	public static final int OFF = 0;
	String place;
	int speed;
	
	public CeilingFan(String place) {
		this.place = place;
		speed = OFF;
	}
	
	public void high() {
		speed = HIGH;//속도 HIGH로 설정
	}
	
	public void medium() {
		speed = MEDIUM;//속도 MEDIUM로 설정
	}
	
	public void low() {
		speed = LOW;//속도 LOW로 설정
	}
	
	public void off() {
		speed = OFF;//선풍기 끄기 위한 코드
	}
	
	public int getSpeed() {
		return speed;
	}
}
