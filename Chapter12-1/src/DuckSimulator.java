
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}
	
	public void simulate() {
		/*//데코레이터 패턴 사용 전
		Quackable mallardDuck = new MallardDuck();
		Quackable redheadDuck = new RedheadDuck();
		Quackable duckCall = new DuckCall();
		Quackable rubberDuck = new RubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());//어댑터 패턴을 이용*/
		
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable gooseDuck = new GooseAdapter(new Goose());//어댑터 패턴을 이용. 이건 거위니까 우는 소리를 세지 않음. 데코레이터를 사용 안함.
		
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
