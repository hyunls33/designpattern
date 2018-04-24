
public class DvdPlayer {

	public void on() {
		System.out.println("DVD 플레이어 켜기");
	}

	public void play(String movie) {
		System.out.println("DVD 플레이어 '"+movie+"' 재생하기");
	}

	public void stop() {
		System.out.println("DVD 플레이어 정지");
	}

	public void eject() {
		System.out.println("DVD 플레이어 꺼내기");
	}

	public void off() {
		System.out.println("DVD 플레이어 끄기");
	}

}
