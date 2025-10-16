package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.StudentDTO;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao stdao;
	@Override
	public StudentDTO fetchStudentById(int sid) {
		StudentBO bo=stdao.getStudentById(sid);
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		dto.setSno(1);
		return dto;
	}
	@Override
	public List<StudentDTO> fetchStudentByName(String name1, String name2) {
		List<StudentBO>stdbo=stdao.getStudentByName(name1, name2);
		List<StudentDTO>stdto=new ArrayList<>();
		stdbo.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			dto.setSid(bo.getSid());
			dto.setSname(bo.getSname());
			dto.setSage(bo.getSage());
			dto.setSaddress(bo.getSaddress());
			dto.setSno(stdto.size()+1);
			stdto.add(dto);
		});
		return stdto;
	}

}
