import java.util.Random;

//����� ���� ����(������ ĥ������ ��ȯ���ִ� �����)
public class DuckAdapter implements Turkey {
	Duck duck;
	Random rand;
	
	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		//duck.fly();//�ٵ� ������ ĥ�������� �ָ� �� �� ����. �̷��� �� ��� ĥ������ ������ŭ ���� ��...
		//�׷��� random�Լ��� �̿��ؼ� 5���� �� ���� �� �� �ֵ��� ��.
		if (rand.nextInt(5)  == 0) {
		     duck.fly();
		}
	}
}
