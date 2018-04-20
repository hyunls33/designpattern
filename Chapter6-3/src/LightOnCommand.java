
public class LightOnCommand implements Command {
	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		//execute()메소드에서는 리시버 객체(light 객체)에 있는 on()메소드를 호출.
		light.on();
	}
	
	public void undo() {
		light.off();//execute()에서는 on()이니까 undo()는 off()를 호출.
	}
}
