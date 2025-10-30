package in.ineuron.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.entity.StockPrice;
import in.ineuron.exception.StockNotFoundException;
import in.ineuron.repositories.IStockRepository;

@Service
public class StockPriceServiceImpl implements IStockPriceService {
	
	@Autowired
	private IStockRepository repo;

	@Override
	public Double findByCompanyName(String companyName) {
		
		StockPrice company= repo.findByCompanyName(companyName);
		if(company==null) {
			throw new StockNotFoundException("company not available");
		}
		return company.getCompanyPrice();
	}

}
