package in.ineuron.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import in.ineuron.service.CensusService;

public class TestCensusService {
	
	private static CensusService service;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("**************************SetUp Started********************************");
		service=new CensusService(); 
	}

	@RepeatedTest(value=10,name="excuting {displayName} of {currentRepetition}/{totalRepetitions}")
	@DisplayName("test export data:")
	@Disabled
	public void testExportData() {
		System.out.println("TestCensusService.testExportData()");
		String exportData = service.exportData();
		assertEquals("Data Exported",exportData);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {10,2,65,48,3,67,8,99,41})
	@Disabled
	public void testIsOdd(int data) {
		boolean result = service.isOdd(data);
		System.out.println("TestCensusService.testIsOdd()::"+ data+":"+result);
		assertTrue(result);
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"sachin","dhoni","kohli"})
	@Disabled
	public void testSayHello(String name) {
		String actualOutput = service.sayHello(name);
		String expectedOutput="Hi::"+name;
		assertEquals(actualOutput,expectedOutput);
	}
	
	
	@ParameterizedTest
	@NullAndEmptySource
	public void testIsEmpty(String name) {
		assertTrue(service.isEmpty(name));
	}
	
	@AfterAll
	public static void cleanUp() {
		service=null;
		System.out.println("*****************************Clenup**************************************");
	}
}
