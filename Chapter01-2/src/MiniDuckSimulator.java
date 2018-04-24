
public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();//MallardDuck에서 상속받은 메소드 호출. 해당 메소드에서는 QuackBehavior에게 할 일 위임. 즉, quackBehavior의 quack()메소드가 호출됨
		mallard.performFly();//MallardDuck에서 상속받은 메소드 호출. 해당 메소드에서는 FlyBehavior에게 할 일 위임. 즉, flyBehavior의 fly()메소드가 호출됨
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());//flyBehavior변경
		model.performFly();
	}
}
