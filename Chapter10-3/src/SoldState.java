
public class SoldState implements State {
	GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("��� ��ٷ� �ּ���. �˸��̰� ������ �ֽ��ϴ�.");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�̹� �˸��̸� �����̽��ϴ�.");
	}

	@Override
	public void turnCrank() {
		System.out.println("�����̴� �� ���� �����ּ���.");
	}

	@Override
	public void dispense() {
		//����ڰ� ������ ����ְ� �����̸� ������ ���� �� ���°� �� �� ����.
		//�ϴ� �̱� ��迡�� �˸��̸� ������.
		gumballMachine.releaseBall();
		//���� �˸��� ���� ���ϱ�
		if (gumballMachine.getCount() > 0) {
			//�˸��̰� �� �ִ� ���
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			//�˸��̰� �� ���� ���
			System.out.println("�˸��̰� �����ϴ�.");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

	@Override
	public void refill() {}
}
