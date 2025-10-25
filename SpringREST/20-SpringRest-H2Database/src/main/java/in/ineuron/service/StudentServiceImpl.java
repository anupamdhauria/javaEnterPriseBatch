package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.exception.StudentRecordNotFoundException;
import in.ineuron.model.Student;

@Service("service")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;
	
	@Override
	public String saveStudent(Student student) {
		 Student dbStudent = dao.save(student);
		 return "Student record saved with the id :: " + dbStudent.getSid();
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> students = dao.findAll();
		return students;
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> studentByID = dao.findById(id);
		if(studentByID.isPresent()) {
			return studentByID.get();
		}else {
			throw new  StudentRecordNotFoundException("Record not found");
		}
		
	}

	@Override
	public String updateStudent(Student student) {
		Student dbStudent = dao.save(student);
		return "Student record updated with the id :: " + dbStudent.getSid();
	}

	@Override
	public String deleteById(Integer id) {
		Optional<Student> optional = dao.findById(id);
		if(optional.isPresent()) {
			dao.deleteById(id);
			return "Deleted succesfully";
		}else {
			throw new  StudentRecordNotFoundException("Record not found");
		}
		
	}

}
