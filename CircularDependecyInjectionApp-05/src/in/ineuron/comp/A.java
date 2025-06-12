package in.ineuron.comp;

public class A {

	private B b;

	static {
		System.out.println("A class is loading..");
	}
	public A() {
		System.out.println("A.A():zero args constructor");
	}
	
	public A(B b) {
		this.b = b;
		System.out.println("A.A():1 param constructor");
	}

	public void setB(B b) {
		this.b=b;
		System.out.println("A.setB()");
	}
	
	 
}
