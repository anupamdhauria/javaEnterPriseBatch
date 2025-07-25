package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Autowired
	@Qualifier("dotnet")
	private ICourse course;
	
	static {
		System.out.println("Student class is loading");
	}
	public Student() {
		System.out.println("Student :zero arg constructor");
	}
	
	public void preparation() {
		System.out.println("Course Material is::"+course.courseContent());
		System.out.println("Course Price is::"+course.price());
	}

	@Override
	public String toString() {
		return "Student [course=" + course + "]";
	}
	
	

}
