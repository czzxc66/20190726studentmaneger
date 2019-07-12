package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Page;
import com.student.bean.Student;
import com.student.mapper.StudentMapper;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 *
	 * @return
	 */
	public List<Student> queryAll() {
		String sql = "select id,name,birthday,age,score,classid,address from student";
		List<Student> studentList = new ArrayList<Student>();
		studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;
	}

	public List<Student> queryPageAll(Page page) {
		String sql = "select id,name,birthday,age,score,classid,address from student limit ?,? ";
		List<Student> studentList = new ArrayList<Student>();
		studentList = jdbcTemplate.query(sql, new Object[] { page.getStar(), page.getPageSize() }, new StudentMapper());
		return studentList;
	}

	public List<Student> queryOrder() {
		String sql = "select id,name,birthday,age,score,classid,address from student";
		List<Student> studentList = new ArrayList<Student>();
		studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;
	}

	public List<Student> querybyName(String name) {
		String sql = "select id,name,birthday,age,score,classid,address from student where name like '%" + name + "%'";
		List<Student> studentList = new ArrayList<Student>();
		studentList = jdbcTemplate.query(sql, new StudentMapper());
		return studentList;
	}

	public boolean addStudent(Student student) {
		String sql = "insert into student (id,name,birthday,age,score,classid,address)" + "values (0,?,?,?,?,?,?)";
		Object stuObj[] = new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),
				student.getClassid(), student.getAddress()

		};
		return jdbcTemplate.update(sql, stuObj) == 1;
	}

	public boolean deleteById(int id) {
		String sql = "delete from student where id=?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	public boolean updateStudent(Student student) {
		String sql = "update student set name=? ,age=? ,birthday=? ,score=?,classid=? ,address=? where id=? ";
		Object stuObj[] = new Object[] { student.getName(), student.getAge(), student.getBirthday(), student.getScore(),
				student.getClassid(), student.getAddress(), student.getId() };
		return jdbcTemplate.update(sql, stuObj) == 1;
	}

	// public List<Student> displayGoodController(){
	// String sql="select id,name,birthday,age,score,classid from student";
	// List<Student> studentList=new ArrayList<Student>();
	// studentList=jdbcTemplate.query(sql, new StudentMapper());
	// double sumScore=0;
	// for(Student stu : studentList) {
	// sumScore=sumScore+stu.getScore();
	// }
	// double averScore=sumScore/studentList.size();
	// List<Student> goodScoreList=new ArrayList<Student>();
	// for(Student stu : studentList) {
	// if(stu.getScore()>averScore) {
	// goodScoreList.add(stu);
	// }
	// }
	// return goodScoreList;
	// }
	// public List<Student> passStudentController(){
	// String sql="select id,name,birthday,age,score,classid from student";
	// List<Student> studentList=new ArrayList<Student>();
	// studentList=jdbcTemplate.query(sql, new StudentMapper());
	// List<Student> passStudentList=new ArrayList<Student>();
	// for(Student stu : studentList) {
	// if(stu.getScore()>=60) {
	// passStudentList.add(stu);
	// }
	// }
	// return passStudentList;
	// }

	// public Double classAverage(int classid){
	// String sql="select score from student where classid like '%"+classid+"%'";
	// Double classAverScore=new Double<student.score()>();
	// classAverScore=jdbcTemplate.query(sql, new StudentMapper());
	// return classAverScore;
	// }
}
