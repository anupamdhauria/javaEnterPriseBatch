package in.ineuron.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.ResultView;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double price);
}
