
public class Singleton {
	//Singleton Ŭ������ ������ �ν��Ͻ��� �����ϱ� ���� ���� ����
	private static Singleton uniqueInstance;
	
	private Singleton() {}//private�� �����߱� ������ Singleton Ŭ���������� Ŭ������ �ν��Ͻ��� ���� �� ����.
	
	public static Singleton getInstance() {//Ŭ������ �ν��Ͻ��� �����Ͽ� ����
		
		if (uniqueInstance == null) {//uniqueInstance�� null�̸� ���� �ν��Ͻ��� �������� �ʾҴٴ� ��.
			//���� �ν��Ͻ��� ��������� �ʾ����� private�� ����� �����ڸ� �̿��ؼ� Single��ü�� ���� ����,
			//uniqueInstance�� �� ��ü�� ����. �̷��� �ν��Ͻ��� �ʿ��� ��Ȳ�� ��ġ�� ������ �ƿ� �ν��Ͻ��� �������� ����.
			//�̷� ����� ������ �ν��Ͻ� ����(lazy Instantiation)�̶�� ��.
			uniqueInstance = new Singleton();
		}//uniqueInstance�� null�� �ƴ� ��쿡�� �̹� ������ ���̹Ƿ� ������ ���� �������ָ� ��.
		
		return uniqueInstance;
	}
}
