package in.ineuron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.entity.StockPrice;

public interface IStockRepository extends JpaRepository<StockPrice, Integer> {

	public StockPrice findByCompanyName(String companyName);
}
