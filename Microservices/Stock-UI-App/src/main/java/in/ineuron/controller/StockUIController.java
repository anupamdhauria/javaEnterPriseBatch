package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.service.IStockService;

@Controller
public class StockUIController {
	
	@Autowired
	private IStockService service;
	
	@GetMapping("/")
	public String loadPage() {
		return "index";
	}

	@PostMapping("/getTotalCost")
	public String getCostPrice(Map<String,Object>map ,@RequestParam("companyName") String companyName,@RequestParam("quantity") Integer quantity) {
		
		String msg = service.getStockprice(companyName, quantity);	
		map.put("msg", msg);
		return "index";
	}
}
