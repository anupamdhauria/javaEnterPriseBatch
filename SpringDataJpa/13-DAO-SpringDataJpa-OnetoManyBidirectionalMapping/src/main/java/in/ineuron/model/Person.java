package in.ineuron.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "OTM_Person")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @NonNull
    private String pname;

    @NonNull
    private String paddress;

    @OneToMany(
        targetEntity = PhoneNumber.class,
        cascade = CascadeType.ALL,
        mappedBy = "person",
        fetch=FetchType.EAGER
     
    )
    private Set<PhoneNumber> contactDetails;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + "]";
	}
}
