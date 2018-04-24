
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);
	}
	
	public void simulate(AbstractDuckFactory duckFactory) {
		//추상 팩토리 사용
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());//어댑터 패턴을 이용
		
		System.out.println("\nDuck Simulator");
		
		Flock flockOfDucks = new Flock();//flock생성
		
		//Quackable을 flock에 넣기(오리떼 객체에 오리 넣기)
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
		
		Flock flockOfMallards = new Flock();
		
		//물오리떼 생성
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		
		//물오리떼 객체에 넣기
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);
		
		//먼저 만든 오리떼 객체에 물오리떼 객체 넣기
		flockOfDucks.add(flockOfMallards);
		
		System.out.println("\nDuck Simulator : Whole Flock Simulation");
		simulate(flockOfDucks);//모든 오리 울기
		
		System.out.println("\nDuck Simulator : Mallard Flock Simulation");
		simulate(flockOfMallards);//물오리떼만 울기
		
		System.out.println("오리가 운 횟수는 : "+QuackCounter.getQuacks()+" 번");
	}
	
	public void simulate(Quackable duck) {
		duck.quack();
	}
}
