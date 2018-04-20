
public class Pizza {
	Pizza orderPizza() {
		Pizza pizza = new Pizza();
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}

	public void box() {
		System.out.println("박스 포장");
	}

	public void cut() {
		System.out.println("피자 컷팅");
	}

	public void bake() {
		System.out.println("피자 굽기");
	}

	public void prepare() {
		System.out.println("피자 준비");
	}
}
