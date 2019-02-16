interface Pizza{
	
	public String getDescription();
	public double getCost();
}

class PlainPizza implements Pizza{

	@Override
	public String getDescription() {
		
		return "Thin Doug";
	}

	@Override
	public double getCost() {
		return 30;
	}
	
}

abstract class ToppingDecorator implements Pizza{
	
	protected Pizza tempPizza;
	
	public ToppingDecorator(Pizza newPizza) {
		this.tempPizza = newPizza;
	}
	
	@Override
	public String getDescription() {
		
		return tempPizza.getDescription();
	}

	@Override
	public double getCost() {
		return tempPizza.getCost();
	}

}

class TomatoSause extends ToppingDecorator{

	public TomatoSause(Pizza newPizza) {
		super(newPizza);
		System.out.println("Adding tomato sause");
		
	}
	
	@Override
	public String getDescription() {
		
		return tempPizza.getDescription() + " , Tomato Sause";
	}

	@Override
	public double getCost() {
		return tempPizza.getCost() + 0.35;
	}
	
	
}

class Cheese extends ToppingDecorator{
	
	public Cheese(Pizza newPizza) {
		super(newPizza);
		System.out.println("Adding cheese");
	}
	
	public String getDescription() {
		return tempPizza.getDescription() + " , Cheese";
	}
	
	public double getCost() {
		return tempPizza.getCost() + 1.52;
	}
}


public class DecoratorPattern {

	public static void main(String[] args) {
		
		Pizza newPizza = new Cheese(new TomatoSause(new PlainPizza()));
		
		System.out.println("Ingredients: " + newPizza.getDescription());
		System.out.println();
		System.out.println("Pirce: " + newPizza.getCost());
	}
}
