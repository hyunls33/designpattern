import java.util.Random;

public class HasQuarterState implements State {
	Random randomWinner = new Random(System.currentTimeMillis());//10%�� Ȯ���� ��÷ ���θ� �����ϴ� ���� �߻���
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
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());			
		}
	}

	@Override
	public void dispense() {
		System.out.println("�˸��̰� ���� �� �����ϴ�.");
	}

	@Override
	public void refill() {}
}
