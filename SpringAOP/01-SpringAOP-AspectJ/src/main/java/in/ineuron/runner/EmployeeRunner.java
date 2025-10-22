package in.ineuron.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.dao.EmpDAO;

@Component
public class EmployeeRunner implements CommandLineRunner{
	@Autowired
	private EmpDAO dao;

	@Override
	public void run(String... args) throws Exception {
		dao.saveEmployee();
		System.out.println();
		dao.getEmployee();
		System.out.println();
		dao.deleteEmployee();
		System.out.println();
		
	}

}
