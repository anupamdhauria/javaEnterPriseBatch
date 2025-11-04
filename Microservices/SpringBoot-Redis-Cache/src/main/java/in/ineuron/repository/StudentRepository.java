package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
