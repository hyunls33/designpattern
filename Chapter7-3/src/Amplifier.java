
public class Amplifier {
	int volum;
	
	public void on() {
		System.out.println("������ �ѱ�");
	}

	public void setDvd(DvdPlayer dvd) {
		System.out.println("������ dvd�� ����");
	}

	public void setSurroundSound() {
		System.out.println("������ �Ҹ� Surround�� ����");
	}

	public void setVolume(int i) {
		this.volum = i;
		System.out.println("������ �Ҹ� "+volum+"���� ����");
	}

	public void off() {
		System.out.println("������ ����");
	}

}
