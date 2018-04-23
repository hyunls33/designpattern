
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);
	}
	
	public void simulate(AbstractDuckFactory duckFactory) {
		//추상 팩토리 사용
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());//어댑터 패턴을 이용
		
		System.out.println("\nDuck Simulator");
		
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);
		
		System.out.println("오리가 운 횟수는 : "+QuackCounter.getQuacks()+" 번");
	}
	
	public void simulate(Quackable duck) {
		duck.quack();
	}
}
