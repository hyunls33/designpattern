
public class WinnerState implements State {
	GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
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
		System.out.println("���ϵ帳�ϴ�! �˸��̸� �ϳ� �� ������ �� �ֽ��ϴ�!");//��÷ �˸�
		//�ϴ� �̱� ��迡�� �˸��̸� ������.
		gumballMachine.releaseBall();
		//���� �˸��� ���� ���ϱ�
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();//�˸��̰� ���������� �ϳ� �� ��������
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("�˸��̰� �����ϴ�.");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}

	@Override
	public void refill() {}

}
