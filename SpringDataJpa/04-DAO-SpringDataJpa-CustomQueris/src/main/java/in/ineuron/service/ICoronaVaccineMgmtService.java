package in.ineuron.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;


public interface ICoronaVaccineMgmtService {
	

	public List<CoronaVaccine>fetchByCompany(String company);
	public List<CoronaVaccine> fetchByPriceLessThan(Double price);
	public List<CoronaVaccine> fetchByCountryAndPrice(Collection<String>countries,double startRange,double endRange);
	public List<CoronaVaccine>fetchByCountryNotIn(Collection<String>countries);
	
}
