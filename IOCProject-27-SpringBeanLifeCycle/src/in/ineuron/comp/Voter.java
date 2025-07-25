package in.ineuron.comp;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="in/ineuron/commons/application.properties")
public class Voter {

	@Value("${voter.info.name}")
	private String name;

	@Value("${voter.info.age}")
	private int age;
	private Date dov;
	static {
		System.out.println("Vote.class is loading");
	}

	public Voter() {
		System.out.println("Voter.Voter() is instantiating.");
		System.out.println(this);
	}

	@PostConstruct 
	public void myInit() {

		System.out.println("Voter.myInit()");
		dov=new Date();
		if(age<0) {
			age=age*-1;
		}else if(age>100) {
			System.out.println("You are too old");
		}else if(age==0) {
			System.out.println("Please enter your valid age");
		}

	}

	public String checkEligibility() {

		String status="";
		if(age<18) {
			status="you are not eligible for Vote";
		}else
		{
			status="you are eligible for Vote";
		}

		return status;

	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("Voter.myDestroy()");	
		age=0;
		dov=null;
		name=null;
	}

	@Override
	public String toString() {
		return "Voter [name=" + name + ", age=" + age + ", dov=" + dov + "]";
	}


}
