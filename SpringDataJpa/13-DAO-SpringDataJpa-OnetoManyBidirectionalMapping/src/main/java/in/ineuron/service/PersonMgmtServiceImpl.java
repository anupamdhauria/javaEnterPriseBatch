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
	public String savePerson(Person person) {
		System.out.println("PersonMgmtServiceImpl.savePerson()");
		Person person1 = personRepo.save(person);
		return "person saved with id::"+person1.getPid();
	}

	@Override
	public String savePhoneNumber(Iterable<PhoneNumber> phoneNumbers) {
		
		int count=0;
		for(PhoneNumber number:phoneNumbers) {
			
			phoneNumberRepo.save(number);
			count++;
		}
		return count +" no of phoneNumbers are saved";
	}

	@Override
	public Iterable<Person> fetchByPerson() {
		List<Person> persons = personRepo.findAll();
		return persons;
	}

	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber() {
		return phoneNumberRepo.findAll();
		
	}

	@Override
	public String deletePersonByID(Integer personId) {
		Optional<Person> person = personRepo.findById(personId);
		if(person.isPresent()) {
			personRepo.deleteById(personId);
			return "person and its phone number both are deleted";
		}
		return "person  not found";
	}

	@Override
	public String deletePhoneNumberOfPerson(Integer personID) {
		Optional<Person> person = personRepo.findById(personID);
		if(person.isPresent()) {
			Set<PhoneNumber> childs = person.get().getContactDetails();
			childs.forEach(child->{
				child.setPerson(null);
			});
			phoneNumberRepo.deleteAll(childs);
			return childs.size()+" record is deleted for person "+personID;
			
		}
		return "person  not found";
	}

}
