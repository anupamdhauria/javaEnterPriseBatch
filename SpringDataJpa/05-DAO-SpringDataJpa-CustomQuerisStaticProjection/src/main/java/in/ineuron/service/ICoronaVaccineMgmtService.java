package in.ineuron.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;


public interface ICoronaVaccineMgmtService {
	

	public List<ResultView> fetchByPriceGreaterThanEqualOrderBy(double price);
	
}
