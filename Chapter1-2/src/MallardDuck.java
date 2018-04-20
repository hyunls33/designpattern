
public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();//우는 행동 정의
		flyBehavior = new FlyWithWings();//나는 행동 정의
	}
	
	public void display() {
		System.out.println("저는 물오리입니다.");
	}
}
