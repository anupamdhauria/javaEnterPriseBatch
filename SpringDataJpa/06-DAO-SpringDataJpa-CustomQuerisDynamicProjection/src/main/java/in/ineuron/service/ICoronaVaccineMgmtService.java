package in.ineuron.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.View;


public interface ICoronaVaccineMgmtService {
	

	public <T extends View> List<T> searchByCountryOrderByCompanyDesc(String company,Class<T> cl);
	
}
