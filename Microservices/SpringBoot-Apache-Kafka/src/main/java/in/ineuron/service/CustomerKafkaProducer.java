package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.ineuron.constants.KafkaConstants;
import in.ineuron.model.Customer;

@Service
public class CustomerKafkaProducer {
	
	@Autowired
	private KafkaTemplate<String,Object>kafkaTemplate;
	
	public String add(List<Customer> customers) {
		
		for(Customer cust:customers) {
			kafkaTemplate.send(KafkaConstants.TOPIC, cust);
			System.out.println("************Msg published to Kafka topic***************");
		}
		
		return "Customer Records Added To Kafka Queue Successfully";
		
		
	}
}
