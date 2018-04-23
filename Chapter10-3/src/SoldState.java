
public class SoldState implements State {
	GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다.");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("이미 알맹이를 뽑으셨습니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("손잡이는 한 번만 돌려주세요.");
	}

	@Override
	public void dispense() {
		//사용자가 동전을 집어넣고 손잡이를 돌렸을 때만 이 상태가 될 수 있음.
		//일단 뽑기 기계에서 알맹이를 내보냄.
		gumballMachine.releaseBall();
		//현재 알맹이 개수 구하기
		if (gumballMachine.getCount() > 0) {
			//알맹이가 더 있는 경우
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			//알맹이가 더 없는 경우
			System.out.println("알맹이가 없습니다.");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

	@Override
	public void refill() {}
}
