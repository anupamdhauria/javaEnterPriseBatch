package in.ineuron.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.service.IPersonMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {

	@Autowired
	IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		// Create a parent object
		/*
		 * Person person = new Person("hyder", "RCB");
		 * 
		 * // Create a child object PhoneNumber p1 = new PhoneNumber(9998887775L,
		 * "airtel", "office"); PhoneNumber p2 = new PhoneNumber(8889997775L, "jio",
		 * "residence");
		 * 
		 * Set<PhoneNumber>numbers=Set.of(p1,p2);
		 * 
		 * person.setContactDetails(numbers);
		 * 
		 * p1.setPerson(person); p2.setPerson(person);
		 * System.out.println(person.toString());
		 * 
		 * String status = service.savePerson(person); System.out.println(status);
		 */
		
		
		
		// Create a parent object
		/*
		 * Person person = new Person("Aditya", "Kolkata");
		 * 
		 * // Create a child object PhoneNumber p1 = new PhoneNumber(4565226665L, "jio",
		 * "office"); PhoneNumber p2 = new PhoneNumber(2523839395L, "vodaphone",
		 * "residence");
		 * 
		 * Set<PhoneNumber>numbers=Set.of(p1,p2);
		 * 
		 * person.setContactDetails(numbers);
		 * 
		 * p1.setPerson(person); p2.setPerson(person);
		 * System.out.println(person.toString());
		 * 
		 * String status = service.savePhoneNumber(numbers); System.out.println(status);
		 */
		
		
		//fetch from parent 
		
		/*
		 * service.fetchByPerson().forEach(person->{
		 * System.out.println("person::"+person); Set<PhoneNumber> contactDetails =
		 * person.getContactDetails();
		 * System.out.println("Contact Details from child::"+contactDetails); });
		 */
		
		
		//delete operation
		
//		System.out.println(service.deletePersonByID(4));
		
		System.out.println(service.deletePhoneNumberOfPerson(5));

	}

}
