
public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	
	//현재 상태
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs) {
		//state인스턴스 각각 생성
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		
		this.count = numberGumballs;
		//알맹이 개수가 0이 아니면 동전을 넣기를 기다리고 있는 NO_QUARTER상태로 전환. 0이면 SOLD_OUT상태.
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	
	//동전이 투입됬을 때의 메소드
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	//사용자가 동전을 반환 받으려고 하는 경우의 메소드
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	//손잡이를 돌리는 경우의 메소드
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	public void releaseBall() {
		System.out.println("알맹이가 나가는 중입니다....");
		if (count != 0) {
			this.count = this.count - 1;
		}
	}

	//알맹이 채우는 메소드
	public void refill(int count) {
		this.count = this.count + count;
		state.refill();
	}

	//정보 메소드
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n뽑기 기계\n");
		result.append("남은 수 : " + count + " 개");
		result.append("\n기계 상태는 "+state+"\n");
		return result.toString();
	}

	//다른 객체에서 뽑기 기계의 상태를 다른 상태로 전환시키는 메소드
	public void setState(State state) {
		this.state = state;
	}
	
	//다른 객체에서 뽑기 기계의 상태를 알아볼 수 있는 메소드
	public State getState() {
        return state;
    }
	
	public State getHasQuarterState() {
		return hasQuarterState;
	}
	
    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

	public int getCount() {
		return this.count;
	}
}