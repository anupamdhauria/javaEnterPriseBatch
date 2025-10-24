package in.ineuron.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	@Pointcut("@annotation(in.ineuron.annotation.MyTransaction)")
	public void p1() {	
	}
	
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("Transaction Begin()");
	}
	
	
	@After("p1()")
	public void endTransaction() {
		System.out.println("Transaction Commit()");
	}
	
}
