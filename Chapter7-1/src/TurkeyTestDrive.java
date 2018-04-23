//어댑터 테스트 코드
public class TurkeyTestDrive {
	public static void main(String[] args) {
		WildTurkey turkey = new WildTurkey();//turkey를 생성.
		
		MallardDuck duck = new MallardDuck();//duck을 생성.
		Turkey duckAdapter = new DuckAdapter(duck);//duck을 duckAdapter로 감싸서 turkey처럼 보이게 만듬.
		
		//duck 자체 테스트
		System.out.println("오리는....");
		duck.quack();
		duck.fly();
		
		//Duck객체를 전달해야 되는 testDuck()메소드를 호출해서 Duck객체를 테스트.
		System.out.println("\n칠면조는...");
		testDuck(turkey);
		
		//오리 대신 칠면조를 넘겨봄!!!! 
		System.out.println("\n오리 어댑터는...");
		testDuck(duckAdapter);
	}
	
	public static void testDuck(Turkey turkey) {//오리하고 칠면조를 전혀 구분하지 못함.
		turkey.gobble();
		turkey.fly();
	}
}
