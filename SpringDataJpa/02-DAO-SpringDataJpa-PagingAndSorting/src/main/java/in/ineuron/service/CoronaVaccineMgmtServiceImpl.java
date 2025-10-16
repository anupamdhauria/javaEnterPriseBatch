package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		
		Iterable<CoronaVaccine>listEntities=repo.findAll(sort);
		return listEntities;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		PageRequest pageble  = PageRequest.of(pageNo, pageSize, asc?Direction.ASC:Direction.DESC, properties);
		Page<CoronaVaccine> page = repo.findAll(pageble);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		Sort sort=Sort.unsorted();
		Iterable<CoronaVaccine>listEntities=repo.findAll(sort);
		int count =((List)listEntities).size();
		int pageCount=count/pageSize;
		pageCount=count%pageSize==0?pageCount:++pageCount;
		for (int i = 0; i < pageCount; i++) {
			PageRequest pageable = PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page = repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("-------------------" + (i + 1) + " of :: " + page.getTotalPages());
		}
		
	}

	

}
