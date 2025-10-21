package in.ineuron;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;

public class App {
    public static void main(String[] args) {
      
    	try {
    	ObjectMapper mapper = new ObjectMapper();
		/*
		 * Customer customer = mapper.readValue(new
		 * File("data/sample-lite.json"),Customer.class); System.out.println(customer);
		 */
    	
    	Customer customer=mapper.readValue(new File("data/sample-full.json"), Customer.class);
    	
    	System.out.println("ID:"+customer.getId());
    	System.out.println("FirstName:"+customer.getFirstName());
    	System.out.println("LastName:"+customer.getLastName());
    	System.out.println("Active:"+customer.isActive());
    	System.out.println("Address:"+customer.getAddress());
    	System.out.println("Languages:");
    	for(String language:customer.getLanguages()) {
    		System.out.print(language+" ");
    	}
    	System.out.println();
    	
    	
    	}catch(IOException io) {
    		io.printStackTrace();
    	}
    }
}
