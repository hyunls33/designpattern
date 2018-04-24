
public class SimpleRemoteControl {
	Command slot;
	
	public SimpleRemoteControl() {}
	
	public void setCommand(Command command) {
		//슬롯을 가지고 제어할 명령을 설정하기 위한 메소드.
		//이 코드를 사용하는 클라이언트에서 리모컨 버튼의 기능을 바꾸고 싶다면 이 메소드를 이용해서 바꿀 수 있음
		slot = command;
	}
	
	public void buttonWasPressed() {
		slot.execute();//버튼이 눌렸을 때 호출되는 메소드
	}
}
