
public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();//��� �ൿ ����
		flyBehavior = new FlyWithWings();//���� �ൿ ����
	}
	
	public void display() {
		System.out.println("���� �������Դϴ�.");
	}
}
