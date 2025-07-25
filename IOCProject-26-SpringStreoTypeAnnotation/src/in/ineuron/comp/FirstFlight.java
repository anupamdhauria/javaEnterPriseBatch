package in.ineuron.comp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value="fFlight")
@Primary
public class FirstFlight implements Courier {

	static {
		System.out.println("FirstFlight class is loading..");
	}

	public FirstFlight() {
		System.out.println("FirstFlight::Zero arg constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("FirstFlight.deliver()");
		return "FirstFlight Courier will delived with the order id ::"+oid+" for the ordered products";
	}

}
