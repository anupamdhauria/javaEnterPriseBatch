package in.ineuron.service;
import java.util.List;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;

public interface ICustomerServiceMgmt {

	public String registerCustomer(String ID,CustomerDTO dto);
	public List<Customer>findAllCustomers();
	public String removeCustomer(String id);
	public List<Customer>fetchByBillAmtBetween(float min,float max);
	public List<Customer> fetchByCnameInAndhavingBillAmt(String ...name);
	
}
