
public class CeilingFanMediumCommand implements Command {
	CeilingFan ceilingFan;
	int prevSpeed;
	
	public CeilingFanMediumCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	
	public void execute() {
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.medium();
		System.out.println(ceilingFan.place+" ¼±Ç³±â ¼Óµµ : "+ceilingFan.getSpeed());
	}
	
	public void undo() {
		if (prevSpeed == CeilingFan.HIGH) {
			ceilingFan.high();			
		} else if (prevSpeed == CeilingFan.MEDIUM) {
			ceilingFan.medium();			
		} else if (prevSpeed == CeilingFan.LOW) {
			ceilingFan.low();			
		} else if (prevSpeed == CeilingFan.OFF) {
			ceilingFan.off();			
		}
		System.out.println(ceilingFan.place+" ¼±Ç³±â ¼Óµµ : "+ceilingFan.getSpeed());
	}
}
