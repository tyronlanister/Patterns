interface Light{
	public void on();
	public void off();
}

class KitchenLight implements Light{

	@Override
	public void on() {
		System.out.println("Kitchen Light Is On");
		
	}

	@Override
	public void off() {
		System.out.println("Kitchen Light Is Off");
		
	}
	
	
}

class LivingRoomLight implements Light{

	@Override
	public void on() {
		System.out.println("Living Room Light Is On");
		
	}

	@Override
	public void off() {
		System.out.println("Living Room Light Is Off");
		
	}
	
}

interface Command{
	public void execute();
}

class LightOnCmd implements Command{

	private Light light;
	
	public LightOnCmd(Light newLight) {
		this.light = newLight;
	}
	
	
	@Override
	public void execute() {
		
		this.light.on();
	}
	
}

class LightOffCmd implements Command{

	private Light light;
	
	public LightOffCmd(Light newLight) {
		this.light = newLight;
	}
	
	
	@Override
	public void execute() {
		
		this.light.off();
	}
	
}

public class CommandPattern {
	
	public static void main(String[] args) {
		
		
		Light livingRoomLight = new LivingRoomLight();
		Light kitchenLight = new KitchenLight();
		
		Command livingRoomLightOnCmd = new LightOnCmd(livingRoomLight);
		Command livingRoomLightOffCmd = new LightOffCmd(livingRoomLight);
		Command kitchenLightOnCmd = new LightOnCmd(kitchenLight);
		Command kitchenLightOffCmd = new LightOffCmd(kitchenLight);
		
		livingRoomLightOnCmd.execute();
		livingRoomLightOffCmd.execute();
		kitchenLightOnCmd.execute();
		kitchenLightOffCmd.execute();
	}

}
