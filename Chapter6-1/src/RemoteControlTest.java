
public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();//�κ�Ŀ(invoker)����.
		Light light = new Light();//��û�� �޾Ƽ� ó���� ���ù�(receiver)�� light��ü
		GarageDoor garageDoor = new GarageDoor();
		LightOnCommand lightOn = new LightOnCommand(light);//Ŀ�ǵ� ��ü ����. �׸��� ���ù� ����
		GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor); 
		
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
	}
}
