interface TV{
	public void on();
	public void off();
	public void switchChannel(int channelNumber);
}

class LGTV implements TV{

	@Override
	public void on() {
		System.out.println("LG tv is on");
		
	}

	@Override
	public void off() {
		System.out.println("LG tv is off");
		
	}

	@Override
	public void switchChannel(int channelNumber) {
		System.out.println("LG TV::CHANNEL: " + channelNumber);
		
	}
	
	
}

class SONYTV implements TV{

	@Override
	public void on() {
		System.out.println("Sony tv is on");
		
	}

	@Override
	public void off() {
		System.out.println("Sony tv is off");
		
	}

	@Override
	public void switchChannel(int channelNumber) {
		System.out.println("SONY TV::CHANNEL: " + channelNumber);
		
	}
	
	
}

interface RemoteController{
	public void on();
	public void off();
	public void switchChannel(int cNumber);
}

class RemoteControllerIm implements RemoteController{

	private TV tv;
	
	public RemoteControllerIm(TV newTV) {
		this.tv = newTV;
	}
	@Override
	public void on() {
		tv.on();
		
	}

	@Override
	public void off() {
		tv.off();
		
	}

	@Override
	public void switchChannel(int cNumber) {
		tv.switchChannel(cNumber);
		
	}
	
}

public class BridgePattern {
	
	public static void main(String[] args) {
		
		TV lgTv = new LGTV();
		TV sonyTv = new SONYTV();
		
		new RemoteControllerIm(lgTv).on();
		new RemoteControllerIm(lgTv).off();
		new RemoteControllerIm(lgTv).switchChannel(5);
		new RemoteControllerIm(sonyTv).on();
		new RemoteControllerIm(sonyTv).off();
		new RemoteControllerIm(sonyTv).switchChannel(10);
	}

}
