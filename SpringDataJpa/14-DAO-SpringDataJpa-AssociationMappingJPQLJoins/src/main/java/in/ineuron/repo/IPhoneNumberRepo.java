package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Integer> {

}
