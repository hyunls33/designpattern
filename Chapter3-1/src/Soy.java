
public class Soy extends CondimentDecorator {//Soy는 데코레이터니까 CondimentDecorator를 상속
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 두유";
	}
	
	public double cost() {
		return .15 + beverage.cost();
	}
}
