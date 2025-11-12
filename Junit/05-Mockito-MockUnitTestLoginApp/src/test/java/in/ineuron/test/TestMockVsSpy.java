package in.ineuron.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestMockVsSpy {

	@Test
	public void testList() {
		
		//mock object is created
		List<String> listMock = Mockito.mock(ArrayList.class);
		System.out.println("Implementation class(Mock):"+listMock.getClass());
		
		Mockito.when(listMock.size()).thenReturn(10);
		System.out.println("Implementation class(Mock):"+listMock.getClass().getSuperclass());
		
		//spy object is created
		List<String> listSpy=Mockito.spy(new ArrayList<String>());
		System.out.println("Implementation class(Spy):"+listSpy.getClass());
		
		Mockito.when(listSpy.size()).thenReturn(10);
		System.out.println("Implementation class(Spy):"+listSpy.getClass().getSuperclass());
		
		
		listMock.add("sachin");
		listSpy.add("sachin");
		
		System.out.println(listMock.size() + "::"  +listSpy.size());
		
	}
}
