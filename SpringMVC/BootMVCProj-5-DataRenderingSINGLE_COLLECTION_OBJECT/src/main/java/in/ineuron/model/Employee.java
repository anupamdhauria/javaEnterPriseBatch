package in.ineuron.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	
	private Integer eno;
	private String ename;
	private String edesg;
	private Double salary;
}
