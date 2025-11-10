package in.ineuron.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.ineuron.service.Printer;

public class TestPrinter {

	@Test
	public void testGetInstance() {
		 Printer p1 = Printer.getInstance();
		 Printer p2 = Printer.getInstance();
//		 assertNotNull(p1);
		 if(p1==null || p2==null) {
			 Assertions.fail("p1,p2 should not be null");
		 }
		 assertSame(p1,p2);
	}
	
}
