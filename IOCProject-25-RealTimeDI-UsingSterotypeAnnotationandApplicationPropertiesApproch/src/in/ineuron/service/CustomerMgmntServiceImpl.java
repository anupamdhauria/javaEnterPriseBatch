package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;

@Service(value="service")
public class CustomerMgmntServiceImpl implements ICustomerMgmntService {
	
	@Autowired
	private ICustomerDAO dao;

	static {
		System.out.println("CustomerMgmntServiceImpl is loading");
	}
	public CustomerMgmntServiceImpl() {
		System.out.println("CustomerMgmntServiceImpl()-zero arg constructor");
	}

//	public CustomerMgmntServiceImpl(ICustomerDAO dao) {
//		this.dao = dao;
//		System.out.println("1 param constructor::"+dao.getClass().getName());
//	}


	@Override
	public String calculateSimpleInterest(CustomerDTO custdto) throws Exception {
		
		CustomerBO bo=new CustomerBO();
		bo.setCustomerName(custdto.getCustomerName());
		bo.setCustomerAddress(custdto.getCustomerAddress());
		bo.setPamt(custdto.getPamt());
		bo.setRate(custdto.getRate());
		bo.setTime(custdto.getTime());
		
		float intAmt=(custdto.getPamt()*custdto.getRate()*custdto.getTime())/100.0f;
		bo.setIntrAmt(intAmt);
		int count=dao.save(bo);
		return count == 0 ? "customer registration failed"
				: "customer registration succesfull---->SimpleInterestAmount::" + intAmt;
	}

}
