package in.ineuron.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import in.ineuron.dao.ILoginDao;
import in.ineuron.service.ILoginMgmtService;
import in.ineuron.service.LoginMgmtServiceImpl;

public class TestAnnotationLoginApp {

	@Mock
	private  ILoginDao loginDaoMock;
	
//	@Spy
//	private  ILoginDao loginDaoSpy;
//	
	@InjectMocks
	private  LoginMgmtServiceImpl service;
	
	public TestAnnotationLoginApp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testWithValidCredentials() {
		System.out.println(loginDaoMock.getClass().getName());
		Mockito.when(loginDaoMock.authenticate("sachin", "tendulkar")).thenReturn(1);
		boolean actualOutput = service.login("sachin", "tendulkar");
		assertTrue(actualOutput);
	
	}
	
	@Test
	public void testWithInvalidCredentials() {
		Mockito.when(loginDaoMock.authenticate("sachin", "sachin@123")).thenReturn(0);
		boolean actualOutput = service.login("sachin", "tendulkar");
		assertTrue(actualOutput);
	}
	
	@Test
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
	


}
