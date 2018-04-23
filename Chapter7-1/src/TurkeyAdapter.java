//어댑터 패턴 연습(칠면조를 오리로 변환해주는 어댑터)
public class TurkeyAdapter implements Duck {//적응시킬 형식의 인터페이스 구현. 클라이언트에서 원하는 인터페이스를 구현해야 함.
	Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {//원래 형식의 객체에 대한 래퍼런스가 필요. 생성자에서 래퍼런스를 받아오는 작업 처리.
		this.turkey = turkey;
	}

	//인터페이스에 있는 메소드를 구현.
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		//두 인터페이스에 모두 fly()메소드가 있지만 칠면도는 오리처럼 멀리 날지 못함.
		//turkey의 fly()를 duck의 fly()에 대응시키기 위해 turkey의 fly()를 다섯번 호출해서 좀 더 멀리 날도록 함.
		for (int i = 0; i < 5; i++) {
			turkey.fly();			
		}
	}
	
}