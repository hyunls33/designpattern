
public class NoQuarterState implements State {
	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("������ �����̽��ϴ�.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("������ �־��ּ���.");
	}

	@Override
	public void turnCrank() {
		System.out.println("������ �־��ּ���.");
	}

	@Override
	public void dispense() {
		System.out.println("������ �־��ּ���.");
	}

	@Override
	public void refill() {}
	
}
