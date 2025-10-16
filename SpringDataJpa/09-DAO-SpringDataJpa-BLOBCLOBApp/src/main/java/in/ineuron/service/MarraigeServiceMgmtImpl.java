package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.MarraigeSeeker;
import in.ineuron.dao.IMarraigeSeekerRepo;

@Service("service")
public class MarraigeServiceMgmtImpl implements IMarraigeServiceMgmt {
	
	@Autowired
	 private IMarraigeSeekerRepo repo;

	@Override
	public String registerMarraigeSeeker(MarraigeSeeker seeker) {
		return "record inserted with id :"+repo.save(seeker).getId();
	}

	@Override
	public Optional<MarraigeSeeker> searchById(Long id) {
		return repo.findById(id);
	}

}
