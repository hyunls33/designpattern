
public class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		name = "Chicage Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
	}
	
	public void cut() {
		//��ī�� ���ڴ� �׸� ������� �ڸ��� ������ cut()�� �������̵� ����.
		System.out.println("Cutting the pizza into square slices");
	}
}
