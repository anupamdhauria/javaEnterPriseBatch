package in.ineuron.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class TestLogin {

	private static WebConversation conversation;
	private static String url=null;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("****************SetUp******************");
		conversation=new WebConversation();
		url="http://localhost:8080/04-HttpUnit/index.html";
	}
	
	@Test
	@DisplayName("test with no inputs")
	public void testProvideCredentials() throws Exception {
		System.out.println("TestLogin.testProvideCredentials()");
		WebResponse response = conversation.getResponse(url);
		WebForm form = response.getForms()[0];
		form.setParameter("uname", "");
		form.setParameter("password", "");
		WebResponse actualResponse = form.submit();
		String actualOutput=actualResponse.getText().trim();
		
		assertEquals("provide credentials", actualOutput);
		
	}
	
	@Test
	@DisplayName("test with valid credentials")
	public void testValidCredentials()throws Exception {
		
		System.out.println("TestLogin.testValidCredentials()");
		WebResponse response = conversation.getResponse(url);
		WebForm form = response.getForms()[0];
		form.setParameter("uname", "sachin");
		form.setParameter("password", "tendulkar");
		WebResponse actualResponse = form.submit();
		String actualOutput=actualResponse.getText().trim();
		
		assertEquals("valid credentials", actualOutput);
	}
	
	@Test
	@DisplayName("test with invalid credentials")
	public void testInvalidCredentials() throws Exception {
		System.out.println("TestLogin.testInvalidCredentials()");
		WebResponse response = conversation.getResponse(url);
		WebForm form = response.getForms()[0];
		form.setParameter("uname", "sachin");
		form.setParameter("password", "sachin@123");
		WebResponse actualResponse = form.submit();
		String actualOutput=actualResponse.getText().trim();
		
		assertEquals("invalid credentials", actualOutput);
	}
	
	public static void cleanUp() {
		conversation=null;
		System.out.println("**************CleanUp****************");
	}
}
