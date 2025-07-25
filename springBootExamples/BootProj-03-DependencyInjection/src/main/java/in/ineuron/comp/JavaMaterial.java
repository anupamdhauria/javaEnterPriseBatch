package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value="java")
public class JavaMaterial implements ICourse {
	
	static {
		System.out.println("JavaMaterial class is loading");
	}
	
	public JavaMaterial() {
		System.out.println("JavaMaterial :: zero arg constructor");
	}

	@Override
	public String courseContent() {
		return "Core Java\nAdvance Java\nSpring and Spring Boot";
	}

	@Override
	public float price() {
		return 12000f;
	}

}
