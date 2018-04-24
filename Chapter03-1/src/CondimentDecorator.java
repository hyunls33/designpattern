//Beverage객체가 들어갈 자리에 들어갈 수 있어야 하므로... Beverage 클래스 확장
public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();//모든 첨가물 데코레이터에서 getDescription메소드를 새로 구현할 계획
}
