
public class Stereo {
	String place;
	
	public Stereo(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place+" 스테레오 켜기");
	}
	
	public void off() {
		System.out.println(place+" 스테레오 끄기");
	}
	
	public void setCD() {
		System.out.println(place+" CD 설정");
	}
	
	public void setDVD() {
		System.out.println(place+" DVD 설정");
	}
	
	public void setRadio() {
		System.out.println(place+" Radio 설정");
	}
	
	public void setVolume(int level) {
		System.out.println(place+" 볼륨 설정 : "+level);
	}
}
