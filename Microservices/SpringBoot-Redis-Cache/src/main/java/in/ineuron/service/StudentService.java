package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.ineuron.model.Student;
import in.ineuron.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	 private  StudentRepository repo;

	
	    @Cacheable(value = "students", key = "#id")
	    public Student getStudentById(Long id) {
	        System.out.println("Fetching student from DB...");
	        return repo.findById(id).orElse(null);
	    }

	    public List<Student> getAllStudents() {
	        return repo.findAll();
	    }

	    @CacheEvict(value = "students", key = "#student.id", condition = "#student.id != null")
	    public Student saveStudent(Student student) {
	        return repo.save(student);
	    }

	    @CacheEvict(value = "students", key = "#id")
	    public void deleteStudent(Long id) {
	        repo.deleteById(id);
	    }
}
