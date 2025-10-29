package in.ineuron.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MTO_PhoneNumber")

public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regNo;
	
	@NonNull
	private Long phoneNo;
	@NonNull
	private String provider;
	@NonNull
	private String type;

	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name = "PERSON_ID", referencedColumnName = "pid")
	private Person person;
	
	

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type
				+ "]";
	}


}
