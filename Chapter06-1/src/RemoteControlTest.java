
public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();//인보커(invoker)역할.
		Light light = new Light();//요청을 받아서 처리할 리시버(receiver)인 light객체
		GarageDoor garageDoor = new GarageDoor();
		LightOnCommand lightOn = new LightOnCommand(light);//커맨드 객체 생성. 그리고 리시버 전달
		GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor); 
		
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
	}
}
