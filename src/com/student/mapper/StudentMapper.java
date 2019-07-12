package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setBirthday(getStringDate(rs.getString("birthday")));
		student.setAge(rs.getInt("age"));
		student.setScore(rs.getDouble("score"));
		student.setClassid(rs.getInt("classid"));
		student.setAddress(rs.getString("address"));
		return student;
	}

	/**
	 * 日付から、文字列に変換する。
	 *　@param date 日付
	 * @return 文字列
	 */

	private  String getStringDate(String birthday) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateString = new Date();
		String strRtnDate = "";
		try {
			dateString = formatter.parse(birthday);
			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strRtnDate;
	}



}
