package in.ineuron.service;

import java.util.Set;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;

public interface IPersonMgmtService {

	public String savePerson(Person person);
	public String savePhoneNumber(Iterable<PhoneNumber> phoneNumbers);
	public Iterable<Person>fetchByPerson();
	public Iterable<PhoneNumber>fetchByPhoneNumber();
	public String deletePersonByID(Integer personId);
	public String deletePhoneNumberOfPerson(Integer personID);
}
