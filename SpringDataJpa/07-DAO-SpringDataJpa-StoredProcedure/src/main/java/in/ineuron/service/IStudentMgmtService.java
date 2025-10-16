package in.ineuron.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ineuron.bo.Student;

@Service("service")
public interface IStudentMgmtService {
	public List<Student> fetchByname(String name1,String name2);

}
