
public class LightOnCommand implements Command {
	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		//execute()�޼ҵ忡���� ���ù� ��ü(light ��ü)�� �ִ� on()�޼ҵ带 ȣ��.
		light.on();
	}
	
	public void undo() {
		light.off();//execute()������ on()�̴ϱ� undo()�� off()�� ȣ��.
	}
}
