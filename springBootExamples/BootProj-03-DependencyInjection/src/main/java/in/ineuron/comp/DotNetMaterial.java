package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value="dotnet")
public class DotNetMaterial implements ICourse {
	
	static {
		System.out.println("DotNetMaterial class is loading");
	}
	
	public DotNetMaterial() {
		System.out.println("DotNetMaterial :: zero arg constructor");
	}

	@Override
	public String courseContent() {
		return "Dotnet Core\nC#\nRest API";
	}

	@Override
	public float price() {
		return 10000f;
	}

}
