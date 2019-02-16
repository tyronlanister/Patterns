import java.util.ArrayList;

interface Subject{
	
	public void register(Observer newObserver);
	public void unRegister(Observer deleteObserver);
	public void notifyObserver();
}

interface Observer{
	
	public void update(double ibmPrice, double aaplPrice, double googPrice);
}

class StockGrabber implements Subject{

	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	public StockGrabber() {
		
		observers = new ArrayList<Observer>();
	}
	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
		
	}

	@Override
	public void unRegister(Observer deleteObserver) {
		int observerIndex = observers.indexOf(deleteObserver);
		observers.remove(observerIndex);
		System.out.println("Observer " + (observerIndex + 1) + " Unregistered");
		
	}

	@Override
	public void notifyObserver() {
		for(Observer observer: observers) {
			observer.update(ibmPrice, aaplPrice, googPrice);
		}
		
	}
	
	public void setIBMPrice(double newPrice) {
		this.ibmPrice = newPrice;
		notifyObserver();
	}
	
	public void setAAPLPrice(double newPrice) {
		this.aaplPrice = newPrice;
		notifyObserver();
	}
	
	public void setGOOGPrice(double newPrice) {
		this.googPrice = newPrice;
		notifyObserver();
	}
	
}

class StockObserver implements Observer{
	
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	private Subject stockGrabber;
	private static int getObserverID = 0;
	private int observerID;
	
	public StockObserver(Subject newStockGrabber) {
		this.stockGrabber = newStockGrabber;
		observerID = ++getObserverID;
		System.out.println("New observer: " + this.observerID + " registered");
		stockGrabber.register(this);
	}
	
	

	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		
		printStockValues();
	}
	
	public void printStockValues() {
		System.out.println("IBM Price: " + this.ibmPrice);
		System.out.println("AAPL Price: " + this.aaplPrice);
		System.out.println("GOOG Price: " + this.googPrice);
		
	}
	
	
}
public class ObserverPattern {
	
	public static void main(String[] args) {
		
		StockGrabber stockGrabber = new StockGrabber();
		
		Observer o1 = new StockObserver(stockGrabber);
		Observer o2 = new StockObserver(stockGrabber);
		
		stockGrabber.setIBMPrice(80);
		stockGrabber.setAAPLPrice(100);
		stockGrabber.setGOOGPrice(200);
		
		
	}

}
