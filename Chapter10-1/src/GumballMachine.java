
public class GumballMachine {
	//4가지 상태 정의
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	//현재 상태를 관리하기 위한 변수
	int state = SOLD_OUT;
	int count = 0;
	
	public GumballMachine(int count) {
		this.count = count;//초기 알맹이 개수를 인자로 받기.
		//알맹이 개수가 0이 아니면 동전을 넣기를 기다리고 있는 NO_QUARTER상태로 전환. 0이면 SOLD_OUT상태.
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	
	//동전이 투입됬을 때의 메소드
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			//동전이 이미 투입되어 있는 경우에는 동전이 이미 들어가 있다고 알림.
			System.out.println("동전은 한 개만 넣어주세요.");
		} else if (state == NO_QUARTER) {
			//동전이 없는데 넣은 경우에는 동전을 받은 다음 받은 상태로 전환.
			state = HAS_QUARTER;
			System.out.println("동전을 넣으셨습니다.");
		} else if (state == SOLD_OUT) {
			//매진 상태에서는 동전을 반환.
			System.out.println("매진되었습니다. 다음 기회에 이용해주세요.");
		} else if (state == SOLD) {
			//방금 손잡이를 돌려서 아직 알맹이 판매상태에 있다면 조금 더 기다려 달라는 메세지 출력.
			System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다.");
		}
	}
	
	//사용자가 동전을 반환 받으려고 하는 경우의 메소드
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			//동전이 있으면 반환하고 NO_QUARTER상태로 전환
			System.out.println("동전이 반환됩니다.");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			//동전이 없는데 돌려줄 수 없음
			System.out.println("동전을 넣어주세요.");
		} else if (state == SOLD_OUT) {
			//손잡이를 이미 돌렸으면 동전을 돌려줄 수 없음. 이미 뽑기를 했으니까.
			System.out.println("이미 알맹이를 뽑으셨습니다.");
		} else if (state == SOLD) {
			//매진 상태에서는 동전을 투입할 수 없기 때문에 돌려줄 일도 없음
			System.out.println("동전을 넣지 않으셨습니다. 동전이 반환되지 않습니다.");
		}
	}
	
	//손잡이를 돌리는 경우의 메소드
	public void turnCrank() {
		if (state == SOLD) {
			//이미 팔렸는데 손잡이를 또 돌리는 경우
			System.out.println("손잡이는 한 번만 돌려주세요.");
		} else if (state == NO_QUARTER) {
			//동전을 먼저 넣어야 함.
			System.out.println("동전을 넣어주세요.");
		} else if (state == SOLD_OUT) {
			//알맹이가 없기 때문에 아무것도 줄 수 없음
			System.out.println("매진되었습니다.");
		} else if (state == HAS_QUARTER) {
			//성공! 사용자가 알맹이를 받을 수 있음.
			System.out.println("손잡이를 돌리셨습니다.");
			state = SOLD;//상태를 SOLD로 전환.
			dispense();//알맹이 꺼내는 메소드 호출
		}
	}
	
	//알맹이 꺼내는 메소드
	public void dispense() {
		if (state == SOLD) {
			//팔렸으므로 알맹이 내보내기
			System.out.println("알맹이가 나가고 있습니다.");
			count = count - 1;
			//매진되었는지 확인
			if (count == 0) {
				//방금 나간 알맹이가 마지막 알맹이면 기계를 SOLD_OUT으로 설정
				System.out.println("더 이상 알맹이가 없습니다.");
				state = SOLD_OUT;
			} else {
				//아니면 NO_QUARTER로 설정
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {
			System.out.println("동전을 넣어주세요.");
		} else if (state == SOLD_OUT) {
			System.out.println("매진입니다.");
		} else if (state == HAS_QUARTER) {
			System.out.println("알맹이가 나갈 수 없습니다.");
		}
	}
	
	//알맹이 채우는 메소드
	public void refill(int count) {
		this.count = this.count + count;
		state = NO_QUARTER;
	}

	//정보 메소드
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n뽑기 기계\n");
		result.append("남은 수 : " + count + " 개");
		result.append("\n기계 상태는 ");
		if (state == SOLD_OUT) {
			result.append("매진");
		} else if (state == NO_QUARTER) {
			result.append("동전 없음. 동전 투입 기다리는 중");
		} else if (state == HAS_QUARTER) {
			result.append("동전 있음. 손잡이 돌리길 기다리는 중");
		} else if (state == SOLD) {
			result.append("알맹이 팔림. 알맹이 내보내는 중");
		}
		result.append("\n");
		return result.toString();
	}
}
