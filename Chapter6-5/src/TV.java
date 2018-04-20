
public class TV {
	String place;
	
	public TV(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place+" TV ÄÑ±â");
	}
	
	public void off() {
		System.out.println(place+" TV ²ô±â");
	}
	
	public void setVolume(int level) {
		System.out.println(place+" TV º¼·ý ¼³Á¤ : "+level);
	}
}
