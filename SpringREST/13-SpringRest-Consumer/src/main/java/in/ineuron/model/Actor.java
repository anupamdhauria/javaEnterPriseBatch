package in.ineuron.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Actor {
	private Integer aid;
	private String name;
	private Integer age;
	private String type;
}
