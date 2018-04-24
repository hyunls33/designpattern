
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);
	}
	
	public void simulate(AbstractDuckFactory duckFactory) {
		//�߻� ���丮 ���
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());//����� ������ �̿�
		
		System.out.println("\nDuck Simulator");
		
		Flock flockOfDucks = new Flock();//flock����
		
		//Quackable�� flock�� �ֱ�(������ ��ü�� ���� �ֱ�)
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
		
		Flock flockOfMallards = new Flock();
		
		//�������� ����
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		
		//�������� ��ü�� �ֱ�
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);
		
		//���� ���� ������ ��ü�� �������� ��ü �ֱ�
		flockOfDucks.add(flockOfMallards);
		
		System.out.println("\nDuck Simulator : Whole Flock Simulation");
		simulate(flockOfDucks);//��� ���� ���
		
		System.out.println("\nDuck Simulator : Mallard Flock Simulation");
		simulate(flockOfMallards);//���������� ���
		
		System.out.println("������ �� Ƚ���� : "+QuackCounter.getQuacks()+" ��");
	}
	
	public void simulate(Quackable duck) {
		duck.quack();
	}
}
