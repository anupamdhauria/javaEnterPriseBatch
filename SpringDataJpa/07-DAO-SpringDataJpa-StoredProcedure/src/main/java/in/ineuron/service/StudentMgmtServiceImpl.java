package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("service")
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private EntityManager manager;
	@Override
	public List<Student> fetchByname(String name1, String name2) {
		System.out.println(manager.getClass().getName());
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_STUDENTS_BY_NAME",Student.class);
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
		
		query.setParameter(1, name1);
		query.setParameter(2, name2);
		return query.getResultList();
	}

}
