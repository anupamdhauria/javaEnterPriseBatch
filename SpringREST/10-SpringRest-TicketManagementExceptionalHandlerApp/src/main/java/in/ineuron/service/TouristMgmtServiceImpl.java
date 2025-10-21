package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ITouristRepo;
import in.ineuron.model.Tourist;
import in.ineuron.Exception.TouristNotFoundException;


@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		
		Integer id = repo.save(tourist).getTid();
		return "New Tourist Data has been added with ID:"+id;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> tourists = repo.findAll();
		tourists.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return tourists;
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		/*
		 * Optional<Tourist> tourist = repo.findById(id); if(tourist.isPresent()) {
		 * return tourist.get(); } throw new
		 * TouristNotFoundException("Tourist not found with id:"+id);
		 */
		return repo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist not found with id:"+id) );
	}

	@Override
	public String updateTouristBtDetails(Tourist tourist) {
		Optional<Tourist> tourist1 = repo.findById(tourist.getTid());
		if(tourist1.isPresent()) {
			repo.save(tourist);
			return "Tourist with the id ::" + tourist.getTid() + " updated";
		}else {
			throw new TouristNotFoundException("Tourist not found with id:"+tourist.getTid() +" for updation");
		}
		
	}

	@Override
	public String updateBudgetByHike(Integer id, Float hikeAmtPercentage) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*hikeAmtPercentage)/100);
			repo.save(tourist);
			return "Tourist with the id ::" + tourist.getTid() + " updated";
		}else {
			throw new TouristNotFoundException("Tourist not found with id:"+id +" for updation");
		}
	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Tourist with the id ::" + id+ " has deleted";
		}else {
			throw new TouristNotFoundException("Tourist not found with id:"+id );
		}
	}

}
