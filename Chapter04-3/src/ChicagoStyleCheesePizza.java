
public class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		name = "Chicage Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
	}
	
	public void cut() {
		//시카고 피자는 네모난 모양으로 자르기 때문에 cut()도 오버라이드 해줌.
		System.out.println("Cutting the pizza into square slices");
	}
}
