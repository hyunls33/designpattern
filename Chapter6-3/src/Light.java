
public class Light {
	String place;
	
	public Light(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place+" ���� �ѱ�");
	}
	
	public void off() {
		System.out.println(place+" ���� ����");
	}
}
