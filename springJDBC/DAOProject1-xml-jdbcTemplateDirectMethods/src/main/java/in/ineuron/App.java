package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.service.EmployeeMgmntServiceImpl;
import in.ineuron.service.IEmployeeManagementService;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		IEmployeeManagementService bean = context.getBean(EmployeeMgmntServiceImpl.class);

		System.out.println("No of Record::" + bean.fetchEmpsCount());
		System.out.println("Employee name is: " + bean.getEmployeeNameById(1));
		Map<String,Object>empData=bean.getEmployeeDetailsById(1);
		System.out.println(empData);
		System.out.println("===================================================");
		bean.getEmployeeDetailsByDesignation("batsman", "keeper").forEach(System.out::println);
		System.out.println("===================================================");
		int rowAffect=bean.insertEmployee("suryakumar", 34, "MI", "batsman", 6000);
		System.out.println("No of row insterted::"+rowAffect);
		
		int rowAffect1=bean.addBonusToEmpByDesg(3000, "batsman");
		System.out.println("No of row updated::"+rowAffect1);
		
		((AbstractApplicationContext) context).close();
	}
}
