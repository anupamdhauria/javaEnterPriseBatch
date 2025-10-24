package in.ineuron.service;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.request.PassangerInfo;
import in.ineuron.response.Ticket;

@Service("service")
public class TicketService {
		
	private static final String REST_END_POINT = "http://localhost:8888/17-SpringRest-TicketBook-ProviderApp/api/ticket/register";

	public void invokeTicketApi() {
		PassangerInfo body = new PassangerInfo();
		body.setFirstName("Sachin");
		body.setLastName("Tendulkar");
		body.setJourneyDate("22/06/2023");
		body.setFrom("Tatanagar");
		body.setTo("Bengaluru");
		body.setTrainNumber("TATA-BENG-1234");
		Ticket response = WebClient.create().post().uri(REST_END_POINT).accept(MediaType.APPLICATION_JSON).
		body(BodyInserters.fromValue(body)).retrieve().bodyToMono(Ticket.class).block();
		System.out.println(response);
	}
}
