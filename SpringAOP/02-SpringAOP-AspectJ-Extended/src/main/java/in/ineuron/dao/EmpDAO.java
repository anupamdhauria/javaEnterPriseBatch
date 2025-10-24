package in.ineuron.dao;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EmpDAO {
	public Integer saveEmployee() {
		/*
		 * if(new Random().nextInt(15)<10) { throw new
		 * RuntimeException("DUMMY EXCEPTION"); }
		 */
		System.out.println("Employee Object is saved...");
		return 10;
	}
	
	
	
}
