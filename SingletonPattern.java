class Singleton{
	
	private static Singleton uniqueInstance;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		
		return uniqueInstance;
	}
}

class ThreadSafeSingleton{
	
	private static ThreadSafeSingleton uniqueInstance;
	
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstance() {
		
		if(uniqueInstance == null) {
			uniqueInstance = new ThreadSafeSingleton();
		}
		
		return uniqueInstance;
	}
}

class ThreadSafeSingleton2{
	
	private volatile static ThreadSafeSingleton2 uniqueInstance;
	
	private ThreadSafeSingleton2() {}
	
	public static ThreadSafeSingleton2 getInstance() {
		
		if(uniqueInstance == null) {
			
			synchronized(ThreadSafeSingleton2.class) {
				
				if(uniqueInstance == null) {
					uniqueInstance = new ThreadSafeSingleton2();
				}
			}
		}
		
		return uniqueInstance;
	}
}
public class SingletonPattern {

}
