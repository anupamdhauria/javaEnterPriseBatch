package in.ineuron.comp;

public class BlueDart implements Courier {

	static {
		System.out.println("BlueDart class is loading..");
	}

	public BlueDart() {
		System.out.println("BlurDart::Zero arg constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		return "BlueDart Courier will delived with the order id ::"+oid+" for the ordered products";
	}

}
