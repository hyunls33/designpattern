
public class TV {
	String place;
	
	public TV(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place+" TV �ѱ�");
	}
	
	public void off() {
		System.out.println(place+" TV ����");
	}
	
	public void setVolume(int level) {
		System.out.println(place+" TV ���� ���� : "+level);
	}
}
