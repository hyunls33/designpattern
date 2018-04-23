//����� �׽�Ʈ �ڵ�
public class TurkeyTestDrive {
	public static void main(String[] args) {
		WildTurkey turkey = new WildTurkey();//turkey�� ����.
		
		MallardDuck duck = new MallardDuck();//duck�� ����.
		Turkey duckAdapter = new DuckAdapter(duck);//duck�� duckAdapter�� ���μ� turkeyó�� ���̰� ����.
		
		//duck ��ü �׽�Ʈ
		System.out.println("������....");
		duck.quack();
		duck.fly();
		
		//Duck��ü�� �����ؾ� �Ǵ� testDuck()�޼ҵ带 ȣ���ؼ� Duck��ü�� �׽�Ʈ.
		System.out.println("\nĥ������...");
		testDuck(turkey);
		
		//���� ��� ĥ������ �Ѱܺ�!!!! 
		System.out.println("\n���� ����ʹ�...");
		testDuck(duckAdapter);
	}
	
	public static void testDuck(Turkey turkey) {//�����ϰ� ĥ������ ���� �������� ����.
		turkey.gobble();
		turkey.fly();
	}
}
