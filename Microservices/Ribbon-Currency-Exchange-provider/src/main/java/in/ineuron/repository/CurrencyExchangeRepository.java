package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.entity.CurrencyExchangeEnitity;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEnitity, Integer> {

	@Query("from CurrencyExchangeEnitity where currencyFrom=:from and currencyTo=:to")
	public CurrencyExchangeEnitity findCurrencyValByFromAndTo(String from,String to); 
}
