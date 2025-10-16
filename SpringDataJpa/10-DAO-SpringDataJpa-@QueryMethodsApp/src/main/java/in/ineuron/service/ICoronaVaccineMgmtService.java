package in.ineuron.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;


public interface ICoronaVaccineMgmtService {
	

	public List<CoronaVaccine>fetchVaccinesByCompany(String company);
	public List<CoronaVaccine>fetchVaccineByCompanies(String comp1,String comp2);
	public List<String>fetchVaccineByPriceRange(double min,double max);
	public List<Object[]>fetchVaccineByNames(String name1,String name2);
	
	
	public int modifyPriceByCountry(double newPrice,String country);
	public int removeVaccineByPrice(double startPrice ,double endPrice);
	public int registerVaccine(String company,String country,String name,Double price,Integer required_dose_count);
	public Date fetchSystemDate();
}
