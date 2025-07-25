package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component
public class Company {

	private String name;
	private Integer size;
	private String location;
	public void setName(String name) {
		this.name = name;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", size=" + size + ", location=" + location + "]";
	}
	
	
}
