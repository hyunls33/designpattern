
public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies[] veggies;
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	public abstract void prepare();

	public void box() {
		System.out.println("피자 상자에 피자 포장하기");
	}

	public void cut() {
		System.out.println("피자 컷팅");
	}

	public void bake() {
		System.out.println("25분동안 350도에서 굽기");
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
		//피자이름출력부분
	}
}
