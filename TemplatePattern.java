abstract class Beverages{
	
	final void prepareRecepie() {
		
		boilWater();
		brew();
		addCondiments();
		pourInCup();
	}
	
	private void boilWater() {
		System.out.println("Boiling Water");
	}
	
	abstract void addCondiments();
	abstract void brew();
	
	private void pourInCup() {
		System.out.println("Pour Into Cup");
	}
}

class Tea extends Beverages{

	@Override
	void addCondiments() {
		System.out.println("Adding Lemon");
		
	}

	@Override
	void brew() {
		System.out.println("Steeping The Tea");
		
	}
	
}

class Coffee extends Beverages{

	@Override
	void addCondiments() {
		System.out.println("Add Sugar And Milk");
		
	}

	@Override
	void brew() {
		System.out.println("Stripping Coffee Through Filter");
		
		
	}
	
}

public class TemplatePattern {

	public static void main(String[] args) {
		
		Beverages tea = new Tea();
		Beverages coffee = new Coffee();
		
		
		tea.prepareRecepie();
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		coffee.prepareRecepie();
	}
}
