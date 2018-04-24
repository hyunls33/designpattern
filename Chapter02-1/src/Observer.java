
public interface Observer {
	//observer인터페이스는 모든 옵저버 클래스에서 구현되야 함. 모든 옵저버는 update()메소드를 구현해야 함.
	public void update(float temp, float humidity, float pressure);//기상정보가 변경되었을 때, 옵저버에게 전달되는 상태값
}
