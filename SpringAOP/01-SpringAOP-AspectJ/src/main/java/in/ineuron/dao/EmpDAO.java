package in.ineuron.dao;

import org.springframework.stereotype.Component;

@Component
public class EmpDAO {
	public void saveEmployee() {
		System.out.println("Employee Object is saved...");
	}
	
	public void getEmployee() {
		System.out.println("Employee Retreived from Database");
	}
	
	public void  deleteEmployee() {
		System.out.println("Record deleted...");	
	}
	
}
