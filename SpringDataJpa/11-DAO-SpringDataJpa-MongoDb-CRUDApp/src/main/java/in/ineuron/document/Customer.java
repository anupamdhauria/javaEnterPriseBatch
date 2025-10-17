package in.ineuron.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Customer {
	@Id
	private String id;
	@NonNull
	private Integer cno;
	@NonNull
	private String cname;
	@NonNull
	private Float billAmt;
	
}
