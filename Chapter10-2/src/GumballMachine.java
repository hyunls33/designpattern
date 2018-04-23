
public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	
	//���� ����
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs) {
		//state�ν��Ͻ� ���� ����
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		
		this.count = numberGumballs;
		//�˸��� ������ 0�� �ƴϸ� ������ �ֱ⸦ ��ٸ��� �ִ� NO_QUARTER���·� ��ȯ. 0�̸� SOLD_OUT����.
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	
	//������ ���ԉ��� ���� �޼ҵ�
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	//����ڰ� ������ ��ȯ �������� �ϴ� ����� �޼ҵ�
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	//�����̸� ������ ����� �޼ҵ�
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	public void releaseBall() {
		System.out.println("�˸��̰� ������ ���Դϴ�....");
		if (count != 0) {
			this.count = this.count - 1;
		}
	}

	//�˸��� ä��� �޼ҵ�
	public void refill(int count) {
		this.count = this.count + count;
		state.refill();
	}

	//���� �޼ҵ�
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n�̱� ���\n");
		result.append("���� �� : " + count + " ��");
		result.append("\n��� ���´� "+state+"\n");
		return result.toString();
	}

	//�ٸ� ��ü���� �̱� ����� ���¸� �ٸ� ���·� ��ȯ��Ű�� �޼ҵ�
	public void setState(State state) {
		this.state = state;
	}
	
	//�ٸ� ��ü���� �̱� ����� ���¸� �˾ƺ� �� �ִ� �޼ҵ�
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