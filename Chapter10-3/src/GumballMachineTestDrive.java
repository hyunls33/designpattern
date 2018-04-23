
public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);//처음에 알맹이 5개로 시작
		
		System.out.println(gumballMachine);//기계 상태 출력
		
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.turnCrank();//손잡이 돌리기
		
		System.out.println(gumballMachine);//기계 상태 출력
		
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.ejectQuarter();//동전 꺼내기
		gumballMachine.turnCrank();//손잡이 돌리기
		
		System.out.println(gumballMachine);//기계 상태 출력
		
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.turnCrank();//손잡이 돌리기
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.turnCrank();//손잡이 돌리기
		gumballMachine.ejectQuarter();//동전 꺼내기
		
		System.out.println(gumballMachine);//기계 상태 출력
		
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.turnCrank();//손잡이 돌리기
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.turnCrank();//손잡이 돌리기
		gumballMachine.insertQuarter();//동전 넣기
		gumballMachine.turnCrank();//손잡이 돌리기
		
		System.out.println(gumballMachine);//기계 상태 출력
	}

}
