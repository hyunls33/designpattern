
public class SoldOutState implements State {
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("�����Ǿ����ϴ�. ���� ��ȸ�� �̿����ּ���.");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�����Ǿ����ϴ�. ���� ��ȸ�� �̿����ּ���.");
	}

	@Override
	public void turnCrank() {
		System.out.println("�����Ǿ����ϴ�. ���� ��ȸ�� �̿����ּ���.");
	}

	@Override
	public void dispense() {
		System.out.println("�˸��̰� ���� �� �����ϴ�.");
	}

	@Override
	public void refill() {
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
}
