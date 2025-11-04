package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;
import in.ineuron.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
    private  StudentService service;

  

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @Operation(summary = "Get student by ID (cached via Redis)")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @Operation(summary = "Save a new student")
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @Operation(summary = "Delete a student by ID")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
