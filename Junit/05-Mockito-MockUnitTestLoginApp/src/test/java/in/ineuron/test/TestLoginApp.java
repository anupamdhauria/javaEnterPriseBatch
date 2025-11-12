package in.ineuron.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import in.ineuron.dao.ILoginDao;
import in.ineuron.service.ILoginMgmtService;
import in.ineuron.service.LoginMgmtServiceImpl;

public class TestLoginApp {

	private static ILoginDao loginDaoMock;
	private static ILoginMgmtService service;
	
	@BeforeAll
	public  static void setUp() {
		System.out.println("**************SetUp***********************\n");
		loginDaoMock = Mockito.mock(ILoginDao.class);
		System.out.println("Implementation class(Mock)::"+loginDaoMock.getClass().getName());
		service = new LoginMgmtServiceImpl(loginDaoMock);
	}
	
	@Test
	@Disabled
	public void testWithValidCredentials() {
		Mockito.when(loginDaoMock.authenticate("sachin", "tendulkar")).thenReturn(1);
		boolean actualOutput = service.login("sachin", "tendulkar");
		assertTrue(actualOutput);
	
	}
	
	@Test
	@Disabled
	public void testWithInvalidCredentials() {
		Mockito.when(loginDaoMock.authenticate("sachin", "sachin@123")).thenReturn(0);
		boolean actualOutput = service.login("sachin", "tendulkar");
		assertTrue(actualOutput);
	}
	@Test
	@Disabled
	public void testWithNoCredentials() {
		Mockito.when(loginDaoMock.authenticate("", "")).thenReturn(0);
		
		//assertTrue(actualOutput);
		assertThrows(IllegalArgumentException.class,()->service.login("", ""));
	}
	
	//spy------------------------------------------------------
	@Test
	public void testWithSpy() {
		ILoginDao loginDaoSpy = Mockito.spy(ILoginDao.class);
		System.out.println("Implementation class is (Spy)::"+loginDaoSpy.getClass());
		ILoginMgmtService service= new LoginMgmtServiceImpl(loginDaoSpy);
		service.register("sachin", "teamlead");
		service.register("kohli", null);
		service.register("dhoni", "visitors");
		service.register("sunil", "");
		
		Mockito.verify(loginDaoSpy, Mockito.times(1)).addUser("sachin", "teamlead");
		Mockito.verify(loginDaoSpy, Mockito.never()).addUser("kohli", null);
		Mockito.verify(loginDaoSpy, Mockito.times(0)).addUser("dhoni", "visitors");
		Mockito.verify(loginDaoSpy, Mockito.never()).addUser("sunil", "");
		
		
		
	}
	
	
	
	@AfterAll
	public static void cleanUp() {
		loginDaoMock=null;
		service=null;
		System.out.println("******************CleanUp**********************\n");
	}
	
	
	
	

}
