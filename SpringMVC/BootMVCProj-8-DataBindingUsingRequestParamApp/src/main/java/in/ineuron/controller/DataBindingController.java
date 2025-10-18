package in.ineuron.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DataBindingController {

	
	@GetMapping("/data")
	public String bindingData(Map<String,Object>model,@RequestParam("sno")Integer sno1,@RequestParam("sname")String sname1) {
		
		System.out.println("DataBindingController.bindingData()");
		System.out.println("SNO   is :: " + sno1);
		System.out.println("SNAME is :: " + sname1);
		return "result";
	}
	
	
	@GetMapping("/data1")
	public String bindingData1(Map<String,Object>model,@RequestParam Integer sno,@RequestParam(required=false)  String sname) {
		
		System.out.println("DataBindingController.bindingData1()");
		System.out.println("SNO   is :: " + sno);
		System.out.println("SNAME is :: " + sname);
		return "result";
	}
	@GetMapping("/data2")
	public String bindingData2(Map<String,Object>model,@RequestParam Integer sno,@RequestParam(defaultValue="sachin")  String sname) {
		
		System.out.println("DataBindingController.bindingData2()");
		System.out.println("SNO   is :: " + sno);
		System.out.println("SNAME is :: " + sname);
		return "result";
	}

}
