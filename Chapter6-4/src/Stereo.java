
public class Stereo {
	String place;
	
	public Stereo(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place+" ���׷��� �ѱ�");
	}
	
	public void off() {
		System.out.println(place+" ���׷��� ����");
	}
	
	public void setCD() {
		System.out.println(place+" CD ����");
	}
	
	public void setDVD() {
		System.out.println(place+" DVD ����");
	}
	
	public void setRadio() {
		System.out.println(place+" Radio ����");
	}
	
	public void setVolume(int level) {
		System.out.println(place+" ���� ���� : "+level);
	}
}
