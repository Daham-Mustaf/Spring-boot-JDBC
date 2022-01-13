package com.daham.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daham.api.Student;
import com.daham.studentrowmapper.StudentRowMapper;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public List<Student> loadSudents() {

		// Write Logic to fetch listOfSudents with db.
		String sql = "SELECT * FROM student ORDER BY id ASC";
		// List<Student> listOfSudents = JdbcTemplate.query(sql, new
		// StudentRowMapper());
		return JdbcTemplate.query(sql, new StudentRowMapper());
	}

	@Override
	public void addStudent(Student student) {
//		INSERT INTO public.student(id, name, moblie, country)
//		VALUES (1, 'daham','12345', 'Iraq');
		String sql = "INSERT INTO student(id, name, moblie, country) VALUES (?, ?, ?)";
		Object[] arg = { student.getName(), student.getMoblie(), student.getCountry() };
		JdbcTemplate.update(sql, arg);
	}

	@Override
	public Student getStudentById(int id) {
		String sql = "SELECT * FROM public.student WHERE id = ? ";
		// Object[] arg = {id};

		return JdbcTemplate.queryForObject(sql, new StudentRowMapper(), new Object[] { id });
	}

	@Override
	public void update(Student student) {

		String sql = "UODATE student SET name= ?, moblie=?, country=? id=? ";
		JdbcTemplate.update(sql, student.getName(), student.getMoblie(), student.getCountry(), student.getId());
		System.out.println("One record updated...");
	}

	@Override
	public void deletStudent(Student student) {
		String sql = "delete from student where id=?";
		JdbcTemplate.update(sql, student.getId());
		System.out.println(student.getId() + "deleted  from the database");

	}

	@Override
	public void addList(List<Student> studentList) {
		
		String sql = "insert into student (name, moblie,country ) values (?, ?, ?)";
		
		List<Object[]> userRows = new ArrayList<Object[]>();
		for (Student student : studentList) {
			userRows.add(new Object[] { student.getName(), student.getMoblie(), student.getCountry() });
		}
		JdbcTemplate.batchUpdate(sql, userRows);
	}

}
