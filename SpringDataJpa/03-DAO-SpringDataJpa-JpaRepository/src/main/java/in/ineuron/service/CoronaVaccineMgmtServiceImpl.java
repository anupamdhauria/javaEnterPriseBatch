package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder,
			String... properties) {
		
		Example<CoronaVaccine> example = Example.of(vaccine);
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		List<CoronaVaccine> listEntries = repo.findAll(example, sort);
		return listEntries;
	}

	@Override
	public CoronaVaccine getVaccineById(Long regNo) {
//		 CoronaVaccine vaccine = repo.getById(regNo);
		 
		 CoronaVaccine vaccine = repo.getReferenceById(regNo);
		return vaccine;
	}

	@Override
	public String removeVaccinesByRegNO(Iterable<Long> regNo) {
		List<CoronaVaccine> listEntities = repo.findAllById(regNo);
		if(listEntities.size()>0) {
			repo.deleteAllByIdInBatch(regNo);
			System.out.println(listEntities.size()+" record deleted.");
		}
		return "Problem in deleting record in batch";
	}

	

}
