//멀티스레딩 문제를 해결한 Singleton 패턴 / DCL(Double-Checking Locking)을 사용.
//일단 인스턴스가 생성되어 있는지 확인한 다음, 생성되지 않았을 경우에만 동기화.
public class SingletonTwo {
	private volatile static SingletonTwo uniqueInstance;//volatile는 자바 1.4버전 이전은 사용 불가
	
	private SingletonTwo() {}
	
	public static SingletonTwo getInstance() {
		//인스턴스가 있는지 확인하고, 없을 경우 동기화 된 블럭으로 들어감.
		if (uniqueInstance == null) {
			//동기화
			synchronized (SingletonTwo.class) {
				//동기화 하고 다시 한 번 null인지 확인한 뒤에 인스턴스 생성 
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonTwo();
				}
			}
		}
		
		return uniqueInstance;
	}
}