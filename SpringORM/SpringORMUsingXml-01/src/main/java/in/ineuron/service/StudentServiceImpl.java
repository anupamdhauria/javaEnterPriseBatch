package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDAO;
import in.ineuron.dto.StudentDTO;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDAO studentDao;

	@Override
	public int insert(StudentDTO dto) {

		StudentBO studentBO = new StudentBO();
		BeanUtils.copyProperties(dto, studentBO);
		return studentDao.insert(studentBO);

	}

	@Override
	public void delete(int id) {
		studentDao.delete(id);

	}

	@Override
	public void delete(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		studentDao.delete(bo);
	}

	@Override
	public void update(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		studentDao.update(bo);
	}

	@Override
	public StudentDTO getStudent(int id) {
		StudentBO bo = studentDao.getStudent(id);
		StudentDTO dto=null;
		if(bo!=null) {
			dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
		}

		return dto;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentBO> students = studentDao.getAllStudents();

		List<StudentDTO> studDTO = new ArrayList<StudentDTO>();

		students.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			studDTO.add(dto);
		});

		return studDTO;
	}

}
