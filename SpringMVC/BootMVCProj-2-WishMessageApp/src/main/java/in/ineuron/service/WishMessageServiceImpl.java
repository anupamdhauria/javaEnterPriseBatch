package in.ineuron.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("service")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateMessage() {
		LocalDateTime lt=LocalDateTime.now();
		int hour=lt.getHour();
		
		if(hour<12) return "Good Morning";
		else if(hour<16) return "Good Afternoon";
		else if(hour<20) return "Good Evening";
		else return "Good Night";
		
	}

}
