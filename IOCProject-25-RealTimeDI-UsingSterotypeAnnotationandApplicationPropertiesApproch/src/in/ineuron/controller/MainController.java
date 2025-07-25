package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmntService;
import in.ineuron.vo.CustomerVO;

@Controller(value="controller")
public class MainController {

	@Autowired
	private ICustomerMgmntService service;

//	public MainController(ICustomerMgmntService service) {
//		this.service = service;
//		System.out.println("1 param constructor::"+service.getClass().getName());
//	}
	
	static {
		System.out.println("MainController is loading");
	}
	public MainController() {
		System.out.println("MainController()-zero arg constructor");
	}
	public String processController(CustomerVO vo) throws Exception{
		
		CustomerDTO dto=new CustomerDTO();
		
		dto.setCustomerName(vo.getCustomerName());
		dto.setCustomerAddress(vo.getCustomerAddress());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		String result=service.calculateSimpleInterest(dto);
		
		return result;
	}
	
}
