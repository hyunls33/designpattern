
public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		Light light = new Light("Living Room");
		TV tv = new TV("Living Room");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();
		
		LightOnCommand lightOn = new LightOnCommand(light);
		StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
		TVOnCommand tvOn = new TVOnCommand(tv);
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);
		
		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		TVOffCommand tvOff = new TVOffCommand(tv);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);
		
		Command[] partyOn = {lightOn, stereoOn, tvOn, hottubOn};
		Command[] partyOff = {lightOff, stereoOff, tvOff, hottubOff};
		
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
		
		//리모컨 슬롯 버튼에 기능 부여
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
		
		System.out.println(remoteControl);
		System.out.println("=== 매크로 켜기 ===");
		remoteControl.onButtonWasPushed(0);
		System.out.println("=== 매크로 끄기 ===");
		remoteControl.offButtonWasPushed(0);
	}
}
