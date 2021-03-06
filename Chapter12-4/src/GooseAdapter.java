//어댑테 패턴을 이용하여 거위를 오리처럼...
public class GooseAdapter implements Quackable{
	Observable observable;
	Goose goose;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
		observable = new Observable(this);
	}
	
	@Override
	public void quack() {
		goose.honk();
	}

	@Override
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers();
	}
}
