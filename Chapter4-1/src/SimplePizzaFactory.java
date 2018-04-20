//팩토리 : 디자인 패턴은 아니지만 자주 쓰이는 형태 예제
public class SimplePizzaFactory {
	
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggi")) {
			pizza = new VeggiPizza();
		}
		
		return pizza;
	}
}
