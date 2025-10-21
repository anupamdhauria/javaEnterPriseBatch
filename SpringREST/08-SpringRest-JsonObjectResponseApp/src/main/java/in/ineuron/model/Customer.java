package in.ineuron.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {

	private Integer cno;
	private String cname;
	private Float billAmount;
	private String[] teamNames;
	private List<String>studies;
	private Set<Long>phoneNumbers;
	private Map<String,Object>idDetails;
	
	private Company company;
}
