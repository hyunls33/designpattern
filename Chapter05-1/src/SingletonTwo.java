//��Ƽ������ ������ �ذ��� Singleton ���� / DCL(Double-Checking Locking)�� ���.
//�ϴ� �ν��Ͻ��� �����Ǿ� �ִ��� Ȯ���� ����, �������� �ʾ��� ��쿡�� ����ȭ.
public class SingletonTwo {
	private volatile static SingletonTwo uniqueInstance;//volatile�� �ڹ� 1.4���� ������ ��� �Ұ�
	
	private SingletonTwo() {}
	
	public static SingletonTwo getInstance() {
		//�ν��Ͻ��� �ִ��� Ȯ���ϰ�, ���� ��� ����ȭ �� ������ ��.
		if (uniqueInstance == null) {
			//����ȭ
			synchronized (SingletonTwo.class) {
				//����ȭ �ϰ� �ٽ� �� �� null���� Ȯ���� �ڿ� �ν��Ͻ� ���� 
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonTwo();
				}
			}
		}
		
		return uniqueInstance;
	}
}