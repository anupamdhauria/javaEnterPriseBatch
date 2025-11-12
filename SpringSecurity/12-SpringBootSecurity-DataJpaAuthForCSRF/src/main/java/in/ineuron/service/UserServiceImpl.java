package in.ineuron.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.ineuron.reposirory.IUsersDetailsRepo;


@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUsersDetailsRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<in.ineuron.model.UserDetails> optional = repo.findByUname(username);
	
		if(optional.isEmpty()) {
			throw new IllegalArgumentException("user not found");
		}else {
			in.ineuron.model.UserDetails userDetails = optional.get();
			
			User user=new User(userDetails.getUname(),
					userDetails.getPwd(),
					userDetails.getRoles().stream()
					.map(role->new SimpleGrantedAuthority(role))
					.collect(Collectors.toSet()));
			return user;
		}
		
	}

	@Override
	public String register(in.ineuron.model.UserDetails details) {
		System.out.println("UserServiceImpl.register()");
		
		details.setPwd(encoder.encode(details.getPwd()));
		return repo.save(details).getUid()+" registed successfully";
		
	}

}
