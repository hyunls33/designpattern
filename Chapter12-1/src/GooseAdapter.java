//어댑테 패턴을 이용하여 거위를 오리처럼...
public class GooseAdapter implements Quackable{
	Goose goose;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}
	
	@Override
	public void quack() {
		goose.honk();
	}
}
