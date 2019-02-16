interface EnemyAttacker{
	
	public void fireWeapon();
	public void driveForward();
	public void assignDriver(String driver);
}

class EnemyTank implements EnemyAttacker{

	@Override
	public void fireWeapon() {
		System.out.println("Enemy Tank Does 10 Damage");
	}

	@Override
	public void driveForward() {
		System.out.println("Enemy Tank Moves 20 Spaces");
		
	}

	@Override
	public void assignDriver(String driver) {
		System.out.println(driver + " Is Driving The Tank");
		
	}
	
}

class EnemyRobot{
	
	public void smashWithHands() {
		System.out.println("Enemy Robot Causes 13 Damage With It's Hands");
	}
	
	public void walksForward() {
		System.out.println("Enemy Robot Walks 39 Spaces");
	}
	
	public void reactToHuman(String name) {
		System.out.println("Enemy Robot Tramps On " + name);
	}
}

class EnemyRobotAdapter implements EnemyAttacker{

	
	private EnemyRobot er;
	
	public EnemyRobotAdapter(EnemyRobot newRobot) {
		this.er = newRobot;
		
	}
	
	
	@Override
	public void fireWeapon() {
		er.smashWithHands();
		
	}

	@Override
	public void driveForward() {
		er.walksForward();
		
	}

	@Override
	public void assignDriver(String driver) {
		er.reactToHuman(driver);
		
	}
	
}


public class AdapterPattern {
	
	public static void main(String[] args) {
		
		EnemyTank et = new EnemyTank();
		et.fireWeapon();
		et.driveForward();
		et.assignDriver("James");
		
		System.out.println();
		System.out.println();
		
		EnemyRobot er = new EnemyRobot();
		er.smashWithHands();
		er.walksForward();
		er.reactToHuman("Nimal");
		
		System.out.println();
		System.out.println();
		
		EnemyRobot eer = new EnemyRobot();
		EnemyRobotAdapter eeerr = new EnemyRobotAdapter(eer);
		
		eeerr.fireWeapon();
		eeerr.driveForward();
		eeerr.assignDriver("Nimal");
	}

}
