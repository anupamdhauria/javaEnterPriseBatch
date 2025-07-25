package in.ineuron.comp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WishMessageGenerator {

	@Autowired(required=true)
	private LocalDateTime date;

	static {
		System.out.println("WishMessageGenerator class file is loading");
	}

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::zero param constructor");
	}

	public String greetMessage(String userName) {
		
		int hour=date.getHour();
		if(hour<12) {
			return "GOOD MORNING::"+userName;
		}else if(hour<16) {
			return "GOOD AFTERNOON::"+userName;
		}else if(hour<20) {
			return "GOOD EVENING::"+userName;
		}else {
			return "GOOD NIGHT::"+userName;
		}
	}

	@Override
	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}

	

}
