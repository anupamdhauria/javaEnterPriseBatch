package in.ineuron.controller;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmntService;
import in.ineuron.vo.CustomerVO;

public class MainController {

	private ICustomerMgmntService service;

	public MainController(ICustomerMgmntService service) {
		this.service = service;
		System.out.println("1 param constructor::"+service.getClass().getName());
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
