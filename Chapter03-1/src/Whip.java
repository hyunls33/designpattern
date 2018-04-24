
public class Whip extends CondimentDecorator {//Whip는 데코레이터니까 CondimentDecorator를 상속
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 휘핑 크림";
	}
	
	public double cost() {
		return .10 + beverage.cost();
	}
}
