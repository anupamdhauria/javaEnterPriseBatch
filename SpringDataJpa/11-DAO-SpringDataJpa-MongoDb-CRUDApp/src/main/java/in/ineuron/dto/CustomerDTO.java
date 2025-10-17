package in.ineuron.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CustomerDTO {
	
	private Integer cno;
	private String cname;
	private Float billAmt;
	
}
