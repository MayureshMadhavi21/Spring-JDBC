package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("StudentDaoImpl")
public class StudentDaoImpl implements StudentDao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
	    //insert query
        String query = "insert into student(id,name,city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}

	public int update(Student student) {
		//update query
		String query = "update student set name=?, city=? where id=?";
		int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}

	public int delete(int studentId) {
		//delete query
		String query = "delete from student where id=?";
		int result = this.jdbcTemplate.update(query,studentId);
		return result;
	}

	public Student getStudent(int studentId) {
		//selecting single student data
		String query = "Select * from student where id=?"; 
		RowMapper<Student> rowMapper = new RowMapperImpl(); 
		//parent class variable can be used to stored child class object
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		//select query selecting all data
		String query = "Select * from student";
		RowMapper<Student> rowMapper = new RowMapperImpl(); 
		List<Student> students = this.jdbcTemplate.query(query,rowMapper);
		return students;
	}

}
