package in.ineuron.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	@Pointcut("execution(public * in.ineuron.dao.EmpDAO.saveEmployee())")
	public void p1() {	
	}
	
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("Transaction Begin()");
	}
	
	@AfterReturning(value="p1()",returning="obj")
	public void commit(Object obj) {
		System.out.println("Employee id is::"+ obj);
		System.out.println("Trasaction Commited()");
	}
	
	@AfterThrowing(value="p1()",throwing="obj")
	public void rollback(Throwable obj) {
		System.out.println("Transaction Rollback()"+ obj.getMessage());
	}
	
	@Around("p1()")
	public void aroundMethod(ProceedingJoinPoint obj) {
		System.out.println("Transaction started");	
		System.out.println("=======================================================");
		try {
			Object object = obj.proceed();
			System.out.println("data is::"+object);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("=======================================================");
		System.out.println("Transaction ended");
		
	}
	
	@After("p1()")
	public void emailSetup() {
		System.out.println("TransactionManagement.emailSetup()");
	}
	
}
