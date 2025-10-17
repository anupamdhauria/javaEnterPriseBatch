package in.ineuron.controller;

import in.ineuron.BootMvcProj1DisplayingHomePageApplication;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestContoller {

    

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}
	
	/*
	 * @RequestMapping(value="/report",method=RequestMethod.GET) public String
	 * showReport1() { System.out.println("TestContoller.showReport1()"); return "";
	 * 
	 * }
	 * 
	 * @RequestMapping(value="/REPORT",method=RequestMethod.GET) public String
	 * showReport2() { System.out.println("TestContoller.showReport2()"); return "";
	 * 
	 * }
	 */
	
//	@RequestMapping(value="/report",method=RequestMethod.POST)
	@PostMapping(value="/report")
	public String showReport1(Map<String,Object> map) {
		System.out.println("TestContoller.showReport1()");
		return "display1";
		
	}
	
	//@RequestMapping(value="/report",method=RequestMethod.GET)
	@GetMapping(value="/report")
	public String showReport2(Map<String,Object> map) {
		System.out.println("TestContoller.showReport2()");
		return "display2";
		
	}
}
