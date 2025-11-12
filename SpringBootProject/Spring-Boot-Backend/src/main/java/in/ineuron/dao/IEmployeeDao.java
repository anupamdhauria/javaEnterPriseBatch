package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Integer> {

}
