package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.StudentBO;

public interface IStudentDao {
	
	public StudentBO getStudentById(int sid);
	public List<StudentBO> getStudentByName(String name1,String name2);
}
