package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.StudentDTO;

public interface IStudentService {

	public StudentDTO fetchStudentById(int sid);
	public List<StudentDTO>fetchStudentByName(String name1,String name2);
	public List<StudentDTO> fetchStuentByCity(String city1,String city2,String city3);
}
