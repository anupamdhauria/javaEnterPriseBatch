package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	@Pointcut("execution(public void in.ineuron.dao.EmpDAO.saveEmployee())")
	public void saveOperation() {
		
	}
	@Pointcut("execution(public void in.ineuron.dao.EmpDAO.deleteEmployee())")
	public void deleteOperation() {
		
	}
	@Pointcut("saveOperation() || deleteOperation()")
	public void operation() {
		
	}
	@Before("operation()")
	public void beginTransaction() {
		System.out.println("Transaction Begin()");
	}
	
	@After("operation()")
	public void commit() {
		System.out.println("Trasaction Commited()");
	}
	
}
