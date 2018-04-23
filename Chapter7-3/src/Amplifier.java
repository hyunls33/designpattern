
public class Amplifier {
	int volum;
	
	public void on() {
		System.out.println("증폭기 켜기");
	}

	public void setDvd(DvdPlayer dvd) {
		System.out.println("증폭기 dvd로 설정");
	}

	public void setSurroundSound() {
		System.out.println("증폭기 소리 Surround로 설정");
	}

	public void setVolume(int i) {
		this.volum = i;
		System.out.println("증폭기 소리 "+volum+"으로 설정");
	}

	public void off() {
		System.out.println("증폭기 끄기");
	}

}
