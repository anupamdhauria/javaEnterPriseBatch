package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.request.PassangerInfo;
import in.ineuron.response.Ticket;

@RestController
@RequestMapping("/api/ticket")
public class TicketProviderController {

	@PostMapping(value="/register")
	public ResponseEntity<Ticket>register(@RequestBody PassangerInfo passenger){
		
		Ticket ticket = new Ticket();
		ticket.setTicketId("1321FF45");
		ticket.setTicketPrice(566.3);
		ticket.setTicketStatus("Booked");
		ticket.setPassengerName(passenger.getFirstName()+" "+passenger.getLastName());
		ticket.setJourneyDate(passenger.getJourneyDate());
		ticket.setTrainNumber(passenger.getTrainNumber());
		ticket.setFrom(passenger.getFrom());
		ticket.setTo(passenger.getTo());	
		
		return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
	}
}
