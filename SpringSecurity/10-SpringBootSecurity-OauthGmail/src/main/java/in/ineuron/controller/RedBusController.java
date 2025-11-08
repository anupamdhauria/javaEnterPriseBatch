package in.ineuron.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusController {


	@GetMapping("/home")
	public String showHomePage(Model model) {
	    return "Hello, Welcome to Home page of RedBus.com";
	
	}

	@GetMapping("/after")
	public String afterLoginPage() {
		return "Hello,Succesfully logged into RedBus.com";
	}

	@GetMapping("/user")
	public Authentication showLoginDetails(Principal principal) {
		System.out.println("Logged in Details :: " + principal.getName());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}
}
