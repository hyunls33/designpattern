//팩토리 : 디자인 패턴은 아니지만 자주 쓰이는 형태 예제
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
		// TODO Auto-generated method stub
		
	}

	public void cut() {
		// TODO Auto-generated method stub
		
	}

	public void bake() {
		// TODO Auto-generated method stub
		
	}

	public void prepare() {
		// TODO Auto-generated method stub
		
	}
}
