
public class DependentPizzaStore {
	//팩토리에 맡기지 않고 직접 할 경우의 의존적인 PizzaStore
	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		
		if (style.equals("NY")) {
			if (type.equals("cheese")) {
				pizza = new NYStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new NYStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new NYStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new NYStylePepperoniPizza();
			}
		} else if (style.equals("Chicago")) {
			if (type.equals("cheese")) {
				pizza = new ChicagoStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new ChicagoStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new ChicagoStylePepperoniPizza();
			}
		} else if (style.equals("California")) {
			if (type.equals("cheese")) {
				pizza = new CaliforniaStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new CaliforniaStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new CaliforniaStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new CaliforniaStylePepperoniPizza();
			}
		} else {
			System.out.println("Error");
			return null;
		}
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
