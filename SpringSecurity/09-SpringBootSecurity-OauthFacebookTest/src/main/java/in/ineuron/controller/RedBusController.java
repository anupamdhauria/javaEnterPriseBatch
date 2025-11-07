package in.ineuron.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;

@Controller
public class RedBusController {


	public String hello(@AuthenticationPrincipal OAuth2User principal ) {
		Map<String,Object> user= principal.getAttributes();
		return "welcome user "+user.get("name");
		
	}
}
