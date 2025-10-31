package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.IStockClient;

@RestController
@RequestMapping("/calc")
public class StockCalculationRestController {
	
	@Autowired
	private IStockClient client;
	
	ResponseEntity<?>responseEntity=null;
	private Double totalPrice=0.0;
	
	@GetMapping("calculate/{companyName}/{quantity}")
	public ResponseEntity<?>calculate(@PathVariable String companyName,@PathVariable Integer quantity){
		
		try {
			
			responseEntity = client.getStockPrice(companyName);
			System.out.println(responseEntity);
			int status=responseEntity.getStatusCode().value();
			if(status==200) {
				Double companyStockPrice=(Double)responseEntity.getBody();
				totalPrice=companyStockPrice*quantity;
				String response="total price:"+totalPrice;
				return new ResponseEntity<String>(response,HttpStatus.OK);
			}

			
		}catch(Exception e) {
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
}
