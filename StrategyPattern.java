interface IFestival{
	public void performEvent();
}

interface IPrograms{
	public void offerPrograms();
}

class CodeFest implements IFestival{

	@Override
	public void performEvent() {
		System.out.println("Perform Code Fest Event");
		
	}
	
}

class RoboFest implements IFestival{

	@Override
	public void performEvent() {
		System.out.println("Perform Robo Fest Event");
		
	}
	
}


class GameFest implements IFestival{

	@Override
	public void performEvent() {
		System.out.println("Perform Game Fest Event");
		
	}
	
}

class DoctoralPrograms implements IPrograms{

	@Override
	public void offerPrograms() {
		System.out.println("Offers Doctroal Programs");
		
	}
	
}

class BScPrograms implements IPrograms{

	@Override
	public void offerPrograms() {
		System.out.println("Offers BSc Programs");
		
	}
	
}

class MScPrograms implements IPrograms{

	@Override
	public void offerPrograms() {
		System.out.println("Offers MSc Programs");
		
	}
	
}

abstract class Student{
	
	IFestival iFestival;
	IPrograms iProgram;
	
	public void conductEvent() {
		iFestival.performEvent();
	}
	
	public void offerProgram() {
		iProgram.offerPrograms();
	}
	
	public void setConductEvent(IFestival iFestival) {
		this.iFestival = iFestival;
	}
	
	public void setOfferProgram(IPrograms iProgram) {
		this.iProgram = iProgram;
	}
	
	abstract void displayStudents();
}

class UnderGrad extends Student{

	public UnderGrad() {
		
		this.setConductEvent(new CodeFest());
		this.setOfferProgram(new BScPrograms());
	}
	@Override
	void displayStudents() {
		System.out.println("Under Graduate Student");
		
	}
	
	
}

class PostGrad extends Student{
	
	public PostGrad() {
		this.setConductEvent(new RoboFest());
		this.setOfferProgram(new DoctoralPrograms());
	}

	@Override
	void displayStudents() {
		System.out.println("Post Graduate Student");
		
	}
	
	
}


public class StrategyPattern {
	
	public static void main(String[] args) {
		
		Student underG = new UnderGrad();
		Student postG = new PostGrad();
		
		postG.offerProgram();
		postG.conductEvent();
		postG.displayStudents();
		
		System.out.println("\n================================Assign New Event================================\n");
		postG.setConductEvent(new CodeFest());
		postG.offerProgram();
		postG.conductEvent();
		
		System.out.println("\n=================================================================\n");
		
		underG.offerProgram();
		underG.conductEvent();
		underG.displayStudents();
		
		System.out.println("\n================================Assign New Event================================\n");
		
		underG.setOfferProgram(new MScPrograms());
		underG.offerProgram();
		underG.conductEvent();
		underG.displayStudents();
		
	}

}
