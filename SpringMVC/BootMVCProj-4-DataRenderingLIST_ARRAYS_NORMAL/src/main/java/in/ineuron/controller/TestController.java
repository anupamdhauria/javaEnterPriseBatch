package in.ineuron.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping
	public String showHome() {
		return "home";
	}
	
	@GetMapping(value="/report")
	public String showReport(Map<String,Object>model) {
		
		model.put("name", "Anupam");
		model.put("age", 49);
		model.put("address", "Galudih");
		
		String[]  countries=new String[] {"UK","India","Germany","Finland","USA"};
		model.put("countries", countries);
		
		List<String> subjects=List.of("Java","Python","JS","DBMS","OS","Networking");
		model.put("subjects", subjects);
		
		Set<Long> mobileNumbers  = Set.of(2343323435L,3334534445L,6424442345L,8722444898L);
		Map<String,Number> ids=Map.of("adhar",68393792093L,"panNo",74839282L,"votarid",32424555L);
		
		model.put("mobileNumbers", mobileNumbers);
		model.put("ids", ids);
		
		
		
		return "show_report";
	}
}
