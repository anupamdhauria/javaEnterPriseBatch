package in.ineuron.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockServiceImpl implements IStockService {

	

	@Override
	public String getStockprice(String companyName, Integer quantity) {
		
		 String REST_END_POINT = "http://localhost:4444/api/calc/calc/calculate/{companyName}/{quantity}";
		 String response=null;
		 
		WebClient webClient=WebClient.create();
		
		try {
			
			response = webClient.get().uri(REST_END_POINT,companyName,quantity).retrieve().bodyToMono(String.class).block();
	
		}catch(Exception e) {
			response="company not found";
		}
		return response;
	}

}
