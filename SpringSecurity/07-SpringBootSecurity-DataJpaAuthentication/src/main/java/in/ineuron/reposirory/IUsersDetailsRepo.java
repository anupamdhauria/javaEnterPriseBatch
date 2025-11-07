package in.ineuron.reposirory;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.UserDetails;

public interface IUsersDetailsRepo extends CrudRepository<UserDetails, Integer> {

	public Optional<UserDetails>findByUname(String name);
}
