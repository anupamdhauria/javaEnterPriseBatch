package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ineuron.Application;
import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.RandomIdGenerator;
import in.ineuron.repository.ICustomerRepo;

@Service("service")
public class CustomerServiceMgmtImpl implements ICustomerServiceMgmt {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(String id,CustomerDTO dto) {
		System.out.println("Implementation Class is:"+repo.getClass().getName());
		if(id==null){
			Customer doc=new Customer();
			BeanUtils.copyProperties(dto, doc);
			doc.setId(RandomIdGenerator.generateId());
			Customer customer = repo.save(doc);
			return "Record Inserted with id:"+customer.getId();
		}else {
			Customer doc=new Customer();
			BeanUtils.copyProperties(dto, doc);
			doc.setId(id);
			Customer customer = repo.save(doc);
			return "Record Updated with id:"+customer.getId();
		}
	}

	@Override
	public List<Customer> findAllCustomers() {
		
		return repo.findAll();
	}

	@Override
	public String removeCustomer(String id) {
		Optional<Customer> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Recored deleted ";
		}
		return "Record not found";
	}

	@Override
	public List<Customer> fetchByBillAmtBetween(float min, float max) {
		
		return repo.findByBillAmtBetween(min, max);
	}

	@Override
	public List<Customer> fetchByCnameInAndhavingBillAmt(String... name) {
		
		return repo.findByCnameInAndBillAmtIsNotNull(name);
	}

}
