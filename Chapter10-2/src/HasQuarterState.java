
public class HasQuarterState implements State {
	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("�̹� ������ �����̽��ϴ�.");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("������ ��ȯ�մϴ�.");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("�����̸� ���Ƚ��ϴ�. �˸��̰� ���ɴϴ�.");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	@Override
	public void dispense() {
		System.out.println("�˸��̰� ���� �� �����ϴ�.");
	}

	@Override
	public void refill() {}
}
