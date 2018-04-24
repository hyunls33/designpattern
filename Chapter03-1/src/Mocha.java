//CondimentDecorator에서 Beverage를 확장함
public class Mocha extends CondimentDecorator {//Mocha는 데코레이터니까 CondimentDecorator를 상속
	Beverage beverage;//감싸고자 하는 음료를 저장하기 위한 인스턴스 변수
	
	public Mocha(Beverage beverage) {
		//인스턴스 변수를 감싸고자 하는 객체로 설정하기 위한 생성자. 데코레이터의 생성자에 감싸고자하는 음료 객체를 전달하는 방식
		this.beverage = beverage;
	}
	
	public String getDescription() {
		//장식하고 있는 객체에 작업을 위임한 다음. 그 결과에 ", 모카"를 더한 결과를 리턴함.
		return beverage.getDescription() + ", 모카";
	}
	
	public double cost() {
		//음료 가격에 모카를 추가한 가격을 계산.
		//장식하고 있는 객체에 가격을 구하는 작업을 위임해서 음료 자체의 값을 구한 다음. 거기에 모카 가격을 더한 값으로 리턴함.
		return .20 + beverage.cost();
	}
}
