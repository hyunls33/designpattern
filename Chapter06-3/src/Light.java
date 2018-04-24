
public class Light {
	String place;
	
	public Light(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place+" 전등 켜기");
	}
	
	public void off() {
		System.out.println(place+" 전등 끄기");
	}
}
