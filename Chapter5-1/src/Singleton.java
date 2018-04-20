
public class Singleton {
	//Singleton 클래스의 유일한 인스턴스를 저장하기 위한 정적 변수
	private static Singleton uniqueInstance;
	
	private Singleton() {}//private로 선언했기 때문에 Singleton 클래스에서만 클래스의 인스턴스를 만들 수 있음.
	
	public static Singleton getInstance() {//클래스의 인스턴스를 생성하여 리턴
		
		if (uniqueInstance == null) {//uniqueInstance가 null이면 아직 인스턴스가 생성되지 않았다는 것.
			//아직 인스턴스가 만들어지지 않았으면 private로 선언된 생성자를 이용해서 Single객체를 만든 다음,
			//uniqueInstance에 그 객체를 대입. 이러면 인스턴스가 필오한 상황이 닥치기 전에는 아예 인스턴스를 생성하지 않음.
			//이런 방법을 게으른 인스턴스 생성(lazy Instantiation)이라고 함.
			uniqueInstance = new Singleton();
		}//uniqueInstance가 null이 아닌 경우에는 이미 생성된 것이므로 생성된 것을 리턴해주면 끝.
		
		return uniqueInstance;
	}
}
