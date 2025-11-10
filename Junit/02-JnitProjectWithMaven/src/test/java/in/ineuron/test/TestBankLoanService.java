package in.ineuron.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import in.ineuron.service.BankLoanService;

@DisplayName("test bankLoanService.class ")
//@TestMethodOrder(value=MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(value=MethodOrderer.DisplayName.class)
//@TestMethodOrder(value=MethodOrderer.MethodName.class)
//@TestMethodOrder(value=MethodOrderer.Random.class)
public class TestBankLoanService {
	
	/*
	private  BankLoanService service;
	
	@BeforeEach
	public  void setup() {
		
		System.out.println("\n***************TestBankLoanService.setup()******************\n");
		service=new BankLoanService();
	}
	
	@AfterEach
	public  void cleanUp() {
		System.out.println("\n*****************TestBankLoanService.cleanUp()*****************\n");
		service=null;
		
	}*/
	
	private static BankLoanService service;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("\n***************TestBankLoanService.setup()******************\n");
		service=new BankLoanService();
	}
	
	@AfterAll
	public static  void cleanUp() {
		System.out.println("\n*****************TestBankLoanService.cleanUp()*****************\n");
		service=null;	
	}

	@Test
	@DisplayName("test with small numbers")
	@Order(1)
	
	@Tag("dev")
	public void testCalSimpleInterestAmountWithSmallNumbers(TestInfo info) {
		System.out.println("TestBankLoanService.testCalSimpleInterestAmountWithSmallNumbers()");
		System.out.println("CLASS NAME:"+info.getClass());
		System.out.println("DISPLAY NAME:"+info.getDisplayName());
		System.out.println("TAG:"+info.getTags());
		System.out.println("METHOD NAME:"+info.getTestMethod());
		System.out.println("TEST METHOD NAME:"+info.getTestClass());
		float actualOutput = service.calculateSimpleIntereset(100000, 2, 12);
		float expectedOutput =24000.0f;
		
		//Method checking for test-case and generating the output
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@Disabled
	public void testCalSimpleInterestAmountWithBigNumbers_1() {
		System.out.println("TestBankLoanService.testCalSimpleInterestAmountWithBigNumbers_1()");
		float actualOutput = service.calculateSimpleIntereset(10000000, 2, 12);
		float expectedOutput =2400000.24f;
		
		//Method checking for test-case and generating the output
		assertEquals(expectedOutput, actualOutput,"Results are not matching");
	}
	
	@Test
	@DisplayName("test with big numbers where precresion in ignored")
	@Order(3)
	@Tag("dev")
	public void testCalSimpleInterestAmountWithBigNumbers_2() {
		System.out.println("TestBankLoanService.testCalSimpleInterestAmountWithBigNumbers_2()");
		float actualOutput = service.calculateSimpleIntereset(10000000, 2, 12);
		float expectedOutput =2400000.345f;
		
		//Method checking for test-case and generating the output
		assertEquals(expectedOutput, actualOutput,0.5f,"Results are not matching");
	}
	
	@Test
	@DisplayName("test with invalid inputs")
	@Order(2)
	public void testCalSimpleInterestAmountWithInvalidNumbers_1() {
		System.out.println("TestBankLoanService.testCalSimpleInterestAmountWithInvalidNumbers_1()");
		assertThrows(IllegalArgumentException.class,()->service.calculateSimpleIntereset(0, 0, 0),"Exceptions are not matching");
	}
	
	@Test
	@Disabled
	public void testCalSimpleInterestAmountWithInvalidNumbers_2() {
		System.out.println("TestBankLoanService.testCalSimpleInterestAmountWithInvalidNumbers_2()");
		float actualOutput = service.calculateSimpleIntereset(0, 0, 0);
		float expectedOutput=0.0f;
		assertEquals(actualOutput,expectedOutput,"invalid inputs");
	}
	
	
	@Test
	@DisplayName("test with timer")
	@Order(0)
	@Tag("uat")
	public void testCalSimpleInterestAmountWithTimer() {
		System.out.println("TestBankLoanService.testCalSimpleInterestAmountWithTimer()");
		BankLoanService service=new BankLoanService();
		assertTimeout(Duration.ofMillis(20000), ()->service.calculateSimpleIntereset(120000, 1, 2));
		
	}
}
