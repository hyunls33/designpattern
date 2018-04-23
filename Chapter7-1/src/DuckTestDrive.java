//����� �׽�Ʈ �ڵ�
public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();//duck�� ����.
		
		WildTurkey turkey = new WildTurkey();//turkey�� ����.
		Duck turkeyAdapter = new TurkeyAdapter(turkey);//turkey�� turkeyAdapter�� ���μ� duckó�� ���̰� ����.
		
		//turkey ��ü �׽�Ʈ
		System.out.println("ĥ������....");
		turkey.gobble();
		turkey.fly();
		
		//Duck��ü�� �����ؾ� �Ǵ� testDuck()�޼ҵ带 ȣ���ؼ� Duck��ü�� �׽�Ʈ.
		System.out.println("\n������...");
		testDuck(duck);
		
		//���� ��� ĥ������ �Ѱܺ�!!!! 
		System.out.println("\nĥ���� ����ʹ�...");
		testDuck(turkeyAdapter);
	}
	
	public static void testDuck(Duck duck) {//�����ϰ� ĥ������ ���� �������� ����.
		duck.quack();
		duck.fly();
	}
}
