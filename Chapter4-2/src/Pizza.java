
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
		System.out.println("�ڽ� ����");
	}

	public void cut() {
		System.out.println("���� ����");
	}

	public void bake() {
		System.out.println("���� ����");
	}

	public void prepare() {
		System.out.println("���� �غ�");
	}
}
