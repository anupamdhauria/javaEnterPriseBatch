package in.ineuron;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Product;


public class App {
    public static void main(String[] args) {
      
    	try {
    		ObjectMapper mapper=new ObjectMapper();
    		Product product=new Product();
    		product=getObjectData(product);
    		System.out.println("in java format::"+product);
//    		String jsonProd = mapper.writeValueAsString(product);
    		mapper.writeValue(new File("product-list.json"), product);
//    		System.out.println("json Format::"+jsonProd);
    		System.out.println("wrote the file in json file");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static Product getObjectData(Product product) {
    	
    	product.setPid(10);
    	product.setPname("fossil");
    	product.setPrice(2344.55);
    	product.setTypes(new String[] {"chronography","simpledial","automatic"});
    	return product;
    }
}
