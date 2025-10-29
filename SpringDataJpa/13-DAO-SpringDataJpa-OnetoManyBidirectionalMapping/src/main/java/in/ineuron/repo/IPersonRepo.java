package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.Person;

public interface IPersonRepo extends JpaRepository<Person,Integer> {

}
