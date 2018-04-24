//어댑터 테스트 코드
public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();//duck을 생성.
		
		WildTurkey turkey = new WildTurkey();//turkey를 생성.
		Duck turkeyAdapter = new TurkeyAdapter(turkey);//turkey를 turkeyAdapter로 감싸서 duck처럼 보이게 만듬.
		
		//turkey 자체 테스트
		System.out.println("칠면조는....");
		turkey.gobble();
		turkey.fly();
		
		//Duck객체를 전달해야 되는 testDuck()메소드를 호출해서 Duck객체를 테스트.
		System.out.println("\n오리는...");
		testDuck(duck);
		
		//오리 대신 칠면조를 넘겨봄!!!! 
		System.out.println("\n칠면조 어댑터는...");
		testDuck(turkeyAdapter);
	}
	
	public static void testDuck(Duck duck) {//오리하고 칠면조를 전혀 구분하지 못함.
		duck.quack();
		duck.fly();
	}
}
