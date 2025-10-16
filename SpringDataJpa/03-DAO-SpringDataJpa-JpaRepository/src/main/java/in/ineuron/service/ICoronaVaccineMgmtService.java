package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;


public interface ICoronaVaccineMgmtService {
	

	public List<CoronaVaccine>searchVaccinesByGivenData(CoronaVaccine vaccine,boolean ascOrder,String... properties);
	public CoronaVaccine getVaccineById(Long regNo);
	public String removeVaccinesByRegNO(Iterable<Long>regNo);
	
	
}
