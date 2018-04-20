
public class Soy extends CondimentDecorator {//Soy�� ���ڷ����ʹϱ� CondimentDecorator�� ���
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", ����";
	}
	
	public double cost() {
		return .15 + beverage.cost();
	}
}
