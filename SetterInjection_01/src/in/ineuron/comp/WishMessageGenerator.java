package in.ineuron.comp;
import java.util.Date;

//target
public class WishMessageGenerator {
	
	//dependent
	private Date date;
	static {
		System.out.println("WishMessageGenerator.class is loading....");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator object is instaintiated...");
	}
	
	public void setDate(Date date) {
		this.date=date;
		System.out.println("Setter method is called for setter Injection..");
	}
	
	//Business Logic Method
	
	public String generateMessage(String username) {
		int hour=date.getHours();
		if(hour<12) {
			return "Good Morning :: "+username;
		}else if(hour<16) {
			return "Good Afternoon:: "+username;
		}else if(hour<20) {
			return "Good Evening:: "+username;
		}else {
			return "Good Night:: "+username;
		}
		
		 
	}
	
	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}
	

}
