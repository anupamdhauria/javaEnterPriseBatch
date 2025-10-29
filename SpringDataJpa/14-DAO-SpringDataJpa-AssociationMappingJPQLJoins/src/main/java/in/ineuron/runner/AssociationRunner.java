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

		service.fetchDataByJoinsUsingParent().forEach(person->{
			for(Object obj:person) {
				System.out.print(obj+" ");
				
			}
			System.out.println();
		});
	}

}
