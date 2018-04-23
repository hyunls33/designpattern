
public class TheaterLights {
	int dim;
	
	public void dim(int i) {
		this.dim = i;
		System.out.println("전등 어둡기 "+dim+"으로 조절");
	}

	public void on() {
		System.out.println("전등 켜기");
	}

}
