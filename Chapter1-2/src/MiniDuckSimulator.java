
public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();//MallardDuck���� ��ӹ��� �޼ҵ� ȣ��. �ش� �޼ҵ忡���� QuackBehavior���� �� �� ����. ��, quackBehavior�� quack()�޼ҵ尡 ȣ���
		mallard.performFly();//MallardDuck���� ��ӹ��� �޼ҵ� ȣ��. �ش� �޼ҵ忡���� FlyBehavior���� �� �� ����. ��, flyBehavior�� fly()�޼ҵ尡 ȣ���
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());//flyBehavior����
		model.performFly();
	}
}
