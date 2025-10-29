package in.ineuron.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.repo.IPersonRepo;
import in.ineuron.repo.IPhoneNumberRepo;

@Service("service")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	IPersonRepo personRepo;
	
	@Autowired
	IPhoneNumberRepo phoneNumberRepo;

	@Override
	public List<Object[]> fetchDataByJoinsUsingParent() {
		return personRepo.getDataUsingJoinsByParent();
		
	}

	
}
