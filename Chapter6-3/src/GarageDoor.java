
public class GarageDoor {
	String place;
	
	public GarageDoor(String place) {
		this.place = place;
	}
	
	public void up() {
		System.out.println(place+" ���� �� ����");
	}
	
	public void down() {
		System.out.println(place+" ���� �� �ݱ�");
	}
	
	public void stop() {
		System.out.println(place+" ���� ����");
	}
	
	public void lightOn() {
		System.out.println(place+" ���� �� �ѱ�");
	}
	
	public void lightOff() {
		System.out.println(place+" ���� �� ����");
	}
}
