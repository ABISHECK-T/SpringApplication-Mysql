package com.techfusion.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techfusion.cms.dao.StudentDao;
import com.techfusion.cms.model.Student;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findById(Integer id) {
        return studentDao.findById(id);
    }
    public Integer save(Student student) {
        return studentDao.save(student);
    }
    
	public Student updateStudent(Integer id, Student student) {
		Student entity = findById(id);
		entity.setStudentName(student.getStudentName());
		entity.setStudentEmail(student.getStudentEmail());
		entity.setDepartmentId(student.getDepartmentId());
		return studentDao.update(entity);
	}
	public Student deleteStudent(Integer id) {

        Student entity = findById(id);

        if (entity != null) {
            studentDao.deleteById(id);
        }

        return entity;
    }
}