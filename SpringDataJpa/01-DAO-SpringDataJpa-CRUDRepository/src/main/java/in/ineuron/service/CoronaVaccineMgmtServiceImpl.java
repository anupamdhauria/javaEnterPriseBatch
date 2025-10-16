package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public String registerVacine(CoronaVaccine vaccine) {

		System.out.println("In Memory Proxy class is::" + repo.getClass().getName());
		CoronaVaccine saveVaccine = null;
		if (vaccine != null) {
			saveVaccine = repo.save(vaccine);

		}

		return saveVaccine != null ? "vaccine registered succesfully with " + saveVaccine.getRegNo()
				: "vaccine registration failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {
		if (vaccines != null) {
			return repo.saveAll(vaccines);
		} else {
			throw new IllegalArgumentException("batch Insertion not done");
		}

	}

	@Override
	public Long getVaccineCount() {

		return repo.count();
	}

	@Override
	public boolean checkAvailablityByRegNo(Long regNo) {
		return repo.existsById(regNo);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return repo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsByID(List<Long> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineById(Long Id) {
		return repo.findById(Id);
	}

	@Override
	public String removeVaccineById(Long id) {
		Optional<CoronaVaccine> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return "record deleted having id:: " + id;
		} else {
			return "record not available for deletion with the id ::" + id;
		}
	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		Optional<CoronaVaccine> optional = repo.findById(vaccine.getRegNo());
		if (optional.isPresent()) {
			repo.delete(vaccine);
			return "record deleted with the given id::" + vaccine.getRegNo();
		} else {
			return "Record not available for deletion with the given id :: " + vaccine.getRegNo();
		}
	}

	@Override
	public String removeVaccinesById(List<Long> ids) {
		Iterable<CoronaVaccine> listVaccine = repo.findAllById(ids);
		int count = ids.size();
		int countlist = ((List) listVaccine).size();
		System.out.println(count + " :" + countlist);
		if (count == ((List) listVaccine).size()) {
			System.out.println("check");
			repo.deleteAllById(ids);
			return count + " no of ids are deleted....";
		}

		return "Problem in deleting records";
	}

}
