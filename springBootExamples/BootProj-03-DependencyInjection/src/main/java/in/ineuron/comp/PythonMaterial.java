package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value="python")
public class PythonMaterial implements ICourse {

	
	static {
		System.out.println("PythonMaterial class is loading");
	}
	
	public PythonMaterial() {
		System.out.println("PythonMaterial :: zero arg constructor");
	}
	
	@Override
	public String courseContent() {
		return "Core Python\nDjango\nMachine Learning";
	}

	@Override
	public float price() {
		return 23000f;
	}

}
