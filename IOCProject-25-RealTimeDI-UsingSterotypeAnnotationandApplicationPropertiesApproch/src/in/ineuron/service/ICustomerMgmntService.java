package in.ineuron.service;

import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgmntService {
	public String calculateSimpleInterest(CustomerDTO custDTO) throws Exception;

}
