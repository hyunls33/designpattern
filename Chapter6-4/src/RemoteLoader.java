
public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		
		//리모컨 슬롯 버튼에 기능 부여
		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		
		remoteControl.onButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}
}
