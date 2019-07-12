package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.commodity.bean.Commodity;

/**
 * StudentMapper数据库映射
 * @ClassName StudentMapper
 */
public class StuMapper implements RowMapper<Commodity> {

	public Commodity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Commodity commodity = new Commodity();
		commodity.setOrder_code(rs.getInt("order_code"));
		commodity.setTokuisaki_code(rs.getString("tokuisaki_code"));
		commodity.setCommodity_code(rs.getString("commodity_code"));
		commodity.setOrder_quantity(rs.getInt("order_quantity"));
		commodity.setOrderday(getStringDate(rs.getString("orderday")));
		return commodity;
	}

	/**
	   * 获取日期
	   * @return 返回日期字符串格式yyyy-MM-dd
	   * @throws ParseException
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