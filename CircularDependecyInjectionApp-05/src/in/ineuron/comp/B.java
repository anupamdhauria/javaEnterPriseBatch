package in.ineuron.comp;

public class B {

	private A a;

	static {
		System.out.println("B class file is loading");
	}
	
	public B() {
		System.out.println("B.B():zero arg constructor");
	}

	
	public B(A a) {
		this.a = a;
		System.out.println("B.B()::1 param constructor");
	}


	public void setA(A a) {
		System.out.println("B.setA()");
		this.a = a;
	}
	
	
}
