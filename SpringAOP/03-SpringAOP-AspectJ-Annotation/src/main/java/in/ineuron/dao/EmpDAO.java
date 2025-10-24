package in.ineuron.dao;


import org.springframework.stereotype.Component;

import in.ineuron.annotation.MyTransaction;

@Component
public class EmpDAO {
	@MyTransaction
	public void saveEmployee() {
		
		System.out.println("Employee Object is saved...");
		
	}
	
	
	
}
