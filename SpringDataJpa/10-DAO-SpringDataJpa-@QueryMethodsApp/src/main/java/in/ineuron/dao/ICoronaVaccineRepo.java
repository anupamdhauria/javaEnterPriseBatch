package in.ineuron.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	/*
	 * @Query("FROM in.ineuron.bo.CoronaVaccine WHERE company=:comp") public
	 * List<CoronaVaccine> searchVaccineByCompany(@Param("comp")String vendor);
	 */
	
	/*
	 * @Query("FROM in.ineuron.bo.CoronaVaccine WHERE company=?1") public
	 * List<CoronaVaccine> searchVaccineByCompany(String vendor);
	 */
	
	@Query("FROM in.ineuron.bo.CoronaVaccine WHERE company=:vendor")
	public List<CoronaVaccine> searchVaccineByCompany(String vendor);
	
	@Query("FROM CoronaVaccine WHERE name IN(:comp1,:comp2)")
	public List<CoronaVaccine> searchVaccinesByCompanies(String comp1,String comp2);
	
	@Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN :min AND :max ")
	public List<String>searchVaccinesByPriceRange(double min,double max);
	
	@Query("SELECT name,company,price from CoronaVaccine")
	public List<Object[]>searchVaccineByNames( String name1,String name2);
	
	@Modifying
	@Transactional
	@Query("Update CoronaVaccine SET price=:newPrice WHERE country=:country")
	public int updatePriceByCountry(double newPrice,String country);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CoronaVaccine WHERE price BETWEEN :startPrice AND :endPrice")
	public int deleteVaccineByPrice(double startPrice ,double endPrice);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO corona_vaccine(`company`,`country`,`name`,`price`,`required_dose_count`)values(?,?,?,?,?)",nativeQuery=true)
	public int insertVaccine(String company,String country,String name,Double price,Integer required_dose_count);
	
	@Query(value="SELECT now() from Dual",nativeQuery=true)
	public Date getSystemDate();
}
