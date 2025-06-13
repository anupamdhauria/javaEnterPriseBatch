package in.ineuron.comp;

public class DTDC implements Courier {

	static {
		System.out.println("DTDC class is loading..");
	}

	public DTDC() {
		System.out.println("DTDC::Zero arg constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("DTDC.deliver()");
		return "DTDC Courier will delived with the order id ::"+oid+" for the ordered products";
	}

}
