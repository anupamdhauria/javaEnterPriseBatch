package in.ineuron.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationController {

	
	@GetMapping("/")
	public String showHome() {
		System.out.println("BankOperationController.showHome()");
		return "home";
	}
	
	
	@GetMapping("/offers")
	public String showoffers() {
		return "offers";
	}
	
	@GetMapping("/balance")
	public String checkBalance(Map<String,Object>map) {
		map.put("balance_amt",new Random().nextInt(1000000));
		return "show_balance";
	}
	
	//csrf check
	@PostMapping("/balance")
	public String checkBalancePost(Map<String,Object>map) {
		map.put("balance_amt",new Random().nextInt(1000000));
		return "show_balance";
	}
	
	@GetMapping("/loanApprove")
	public String approveLoan(Map<String,Object>map) {
		map.put("amount",new Random().nextInt(1000000));
		return "loan";
	}
	
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}
}
