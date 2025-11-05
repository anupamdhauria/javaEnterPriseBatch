package in.ineuron.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import in.ineuron.constants.KafkaConstants;
import in.ineuron.model.Customer;

@Service
public class CustomerKafkaConsumer {

	@KafkaListener(topics=KafkaConstants.TOPIC,groupId=KafkaConstants.GROUP_ID)
	public void getCustomerData(Customer customer) {
		System.out.println("***Msg recieved from Kafka Topic ::" + customer);
	}
}
