import java.util.Random;

//어댑터 패턴 연습(오리를 칠면조로 변환해주는 어댑터)
public class DuckAdapter implements Turkey {
	Duck duck;
	Random rand;
	
	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		//duck.fly();//근데 오리는 칠면조보다 멀리 날 수 있음. 이렇게 할 경우 칠면조가 오리만큼 날게 됨...
		//그래서 random함수를 이용해서 5번에 한 번만 날 수 있도록 함.
		if (rand.nextInt(5)  == 0) {
		     duck.fly();
		}
	}
}
