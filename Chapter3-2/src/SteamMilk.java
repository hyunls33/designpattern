
public class SteamMilk extends CondimentDecorator {//SteamMilk는 데코레이터니까 CondimentDecorator를 상속
	Beverage beverage;
	
	public SteamMilk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 스팀 밀크";
	}
	
	public double cost() {
		return .10 + beverage.cost();
	}
}
