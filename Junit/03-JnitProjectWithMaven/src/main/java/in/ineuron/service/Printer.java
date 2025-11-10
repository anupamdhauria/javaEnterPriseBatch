package in.ineuron.service;

//Singleton Design Pattern
public class Printer {

	private static Printer INSTANCE=new Printer();
	
	private Printer() {
		
	}
	
	public static Printer getInstance() {
		return INSTANCE;
	}
}
