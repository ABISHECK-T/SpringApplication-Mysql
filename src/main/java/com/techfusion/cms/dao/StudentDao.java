package com.techfusion.cms.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techfusion.cms.model.Student;

@Repository
public class StudentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {

        String query = "SELECT student_id, student_name, student_email, department_id FROM student";

        return jdbcTemplate.query(query, studentRowMapper);
    }

    public Student findById(Integer id) {

        String query = "SELECT student_id, student_name, student_email, department_id "
                + "FROM student WHERE student_id = ?";

        return jdbcTemplate.queryForObject(query, studentRowMapper, id);
    }

    public Integer save(Student student) {

        String query = "INSERT INTO student(student_name, student_email, department_id) VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                query,
                student.getStudentName(),
                student.getStudentEmail(),
                student.getDepartmentId());
    }

    public Student update(Student student) {

        String query = "UPDATE student SET student_name = ?, student_email = ?, department_id = ? "
                + "WHERE student_id = ?";

        jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getStudentEmail());
            ps.setInt(3, student.getDepartmentId());
            ps.setInt(4, student.getStudentId());

            return ps;
        });

        return student;
    }
    public int deleteById(Integer id) {

        String query = "DELETE FROM student WHERE student_id = ?";

        return jdbcTemplate.update(query, id);
    }
    private final RowMapper<Student> studentRowMapper = (rs, rowNum) -> {

        Student student = new Student();

        student.setStudentId(rs.getInt("student_id"));
        student.setStudentName(rs.getString("student_name"));
        student.setStudentEmail(rs.getString("student_email"));
        student.setDepartmentId(rs.getInt("department_id"));

        return student;
    };
    
}