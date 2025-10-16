package in.ineuron.controller;

import in.ineuron.Application;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController //combination of @Controller and @ResponseBody
public class Test {
	
	@RequestMapping("/about")
	public String aboutHandler() {
		System.out.println("This is about page");
		return "about page";
	}
	
	@RequestMapping("/welcome")
	public String messageHandler() {
		System.out.println("Test.messageHandler()");
		return "Welcome to Spring mvc with boot";
	}

	@RequestMapping("/course-name")
	public List<String> courseName(){
		System.out.println("Test.courseName()");
		return Arrays.asList("Java","React JS","Python");
	}
}
