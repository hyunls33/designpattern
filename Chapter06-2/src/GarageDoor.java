
public class GarageDoor {
	String place;
	
	public GarageDoor(String place) {
		this.place = place;
	}
	
	public void up() {
		System.out.println(place+" 차고 문 열기");
	}
	
	public void down() {
		System.out.println(place+" 차고 문 닫기");
	}
	
	public void stop() {
		System.out.println(place+" 차고 정지");
	}
	
	public void lightOn() {
		System.out.println(place+" 차고 불 켜기");
	}
	
	public void lightOff() {
		System.out.println(place+" 차고 불 끄기");
	}
}
