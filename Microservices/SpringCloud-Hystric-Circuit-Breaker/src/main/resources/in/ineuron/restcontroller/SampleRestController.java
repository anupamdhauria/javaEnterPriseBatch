package in.ineuron.restcontroller;


@RestController
@RequestMapping("api/order")
public class SampleRestController {

	@GetMapping("/show")
	@HystrixCommand(fallbackMethod="showFallBack")
	public String getOrderDetails() {
		System.out.println("SampleRestController.getOrderDetails()");
		if(Random().next(10)<10) {
			throw new Runtime("Dummy Error");
		}
		return "Hello From Provider";
	}
	
	public String showFallBack() {
		System.out.println("SampleRestController.showFallBack()");
		return "Hii From Fallback";
	}
}
