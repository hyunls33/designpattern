
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}
	
	public void simulate() {
		/*//���ڷ����� ���� ��� ��
		Quackable mallardDuck = new MallardDuck();
		Quackable redheadDuck = new RedheadDuck();
		Quackable duckCall = new DuckCall();
		Quackable rubberDuck = new RubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());//����� ������ �̿�*/
		
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable gooseDuck = new GooseAdapter(new Goose());//����� ������ �̿�. �̰� �����ϱ� ��� �Ҹ��� ���� ����. ���ڷ����͸� ��� ����.
		
		System.out.println("\nDuck Simulator");
		
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);
		
		System.out.println("������ �� Ƚ���� : "+QuackCounter.getQuacks()+" ��");
	}
	
	public void simulate(Quackable duck) {
		duck.quack();
	}
}
