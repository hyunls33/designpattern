//����� ���� ����(ĥ������ ������ ��ȯ���ִ� �����)
public class TurkeyAdapter implements Duck {//������ų ������ �������̽� ����. Ŭ���̾�Ʈ���� ���ϴ� �������̽��� �����ؾ� ��.
	Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {//���� ������ ��ü�� ���� ���۷����� �ʿ�. �����ڿ��� ���۷����� �޾ƿ��� �۾� ó��.
		this.turkey = turkey;
	}

	//�������̽��� �ִ� �޼ҵ带 ����.
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		//�� �������̽��� ��� fly()�޼ҵ尡 ������ ĥ�鵵�� ����ó�� �ָ� ���� ����.
		//turkey�� fly()�� duck�� fly()�� ������Ű�� ���� turkey�� fly()�� �ټ��� ȣ���ؼ� �� �� �ָ� ������ ��.
		for (int i = 0; i < 5; i++) {
			turkey.fly();			
		}
	}
	
}