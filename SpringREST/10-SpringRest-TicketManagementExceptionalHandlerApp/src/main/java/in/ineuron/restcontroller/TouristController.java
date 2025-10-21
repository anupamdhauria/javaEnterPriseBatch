package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String>enrollTourist(@RequestBody Tourist tourist){
	
			String registerTourist = service.registerTourist(tourist);
			return new ResponseEntity<String>(registerTourist,HttpStatus.OK);

	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?>displayTouristDetails(){
		
			List<Tourist> tourists = service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(tourists,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?>displayTouristById(@PathVariable("id") Integer Id){
		
			Tourist tourist = service.fetchTouristById(Id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String>modifyTourist(@RequestBody Tourist tourist){
		
			 String details = service.updateTouristBtDetails(tourist);
			return new ResponseEntity<String>(details,HttpStatus.OK);
		
	}
	
	@PatchMapping("/modify/{id}/{hike}")
	public ResponseEntity<String>modifyTouristById(@PathVariable Integer id,@PathVariable("hike") Float hikeAmtPercentage){
		
			String byHike = service.updateBudgetByHike(id, hikeAmtPercentage);
			return new ResponseEntity<String>(byHike,HttpStatus.OK);
		
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteTouristById(@PathVariable Integer id){
		
			String deleteId = service.deleteTouristById(id);
			return new ResponseEntity<String>(deleteId,HttpStatus.OK);
		
	}
}
