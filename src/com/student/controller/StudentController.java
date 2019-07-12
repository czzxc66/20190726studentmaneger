package com.student.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.ClassScoreForm;
import com.student.bean.CountScoreDto;
import com.student.bean.Page;
import com.student.bean.Student;
import com.student.dao.StudentDao;

/**
 *
 * @author Administrator
 *
 */
@Controller
public class StudentController {

	private Object getStudentDao(String daoName) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object studao = context.getBean(daoName);
		return studao;
	}

	/**
	 *
	 * @param model
	 * @return
	 */

	// @RequestMapping(value = "/all")
	// public String queryAll(Model model) {
	// StudentDao studao = (StudentDao)getStudentDao("studentdao");
	// model.addAttribute("students", studao.queryAll());
	// return "index";
	// }

	// @RequestMapping(value = "/fenye")

	@RequestMapping(value = "/all")
	public String fen(Page page, Model model) {

		try {
			StudentDao studao = (StudentDao) getStudentDao("studentdao");
			// 查询出的list数据
			List<Student> showdata = studao.queryAll();
			// 刚开始的页面为第一页
			if (page.getCurrentPage() == null) {
				page.setCurrentPage(1);
			} else {
				page.setCurrentPage(page.getCurrentPage());
			}
			// 设置每页数据为十条
			page.setPageSize(10);
			// 每页的开始数
			page.setStar((page.getCurrentPage() - 1) * page.getPageSize());
			// list的大小
			int count = showdata.size();
			// 设置总页数
			page.setTotalPage(count % 10 == 0 ? count / 10 : count / 10 + 1);
			// 对list进行截取
			page.setDataList(showdata.subList(page.getStar(),
					count - page.getStar() > page.getPageSize() ? page.getStar() + page.getPageSize() : count));
			// 设置作用域
			model.addAttribute("paging", page);
			// request.setAttribute("paging", page);
			model.addAttribute("students", showdata.subList(page.getStar(),
					count - page.getStar() > page.getPageSize() ? page.getStar() + page.getPageSize() : count));
			return "index";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "mistake";
		}

	}

	@RequestMapping(value = "/queryByName")
	public String querybyname(String name, Model model) {
		StudentDao studao = (StudentDao) getStudentDao("studentdao");
		model.addAttribute("students", studao.querybyName(name));
		return "index";
	}

	@RequestMapping(value = "/add")
	public String addStudent(String id, String name, String birthday, int age, double score, int classid,
			String address, Model model) {
		StudentDao studao = (StudentDao) getStudentDao("studentdao");
		Student student = new Student();
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(age);
		student.setScore(score);
		student.setClassid(classid);
		student.setAddress(address);
		model.addAttribute("students", student);
		boolean result = studao.addStudent(student);
		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失败！')</script>");
		}
		model.addAttribute("students", studao.queryAll());
		return "index";
	}

	@RequestMapping(value = "/deleteById")
	public String deleteById(int id, Model model) {
		StudentDao studao = (StudentDao) getStudentDao("studentdao");
		boolean result = studao.deleteById(id);
		if (result) {
			model.addAttribute("msg", "<script>alert('删除成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('删除失败！')</script>");
		}
		model.addAttribute("students", studao.queryAll());
		return "index";
	}

	@RequestMapping(value = "/update")
	public String updateStudent(String id, String name, String birthday, int age, int score, int classid,
			String address, Model model) {
		StudentDao studao = (StudentDao) getStudentDao("studentdao");
		Student student = new Student();
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(age);
		student.setScore(score);
		student.setClassid(classid);
		student.setAddress(address);
		student.setId(Integer.parseInt(id));

		boolean result = studao.updateStudent(student);
		// update成功
		if (result) {
			System.out.println("update成功");
		} else {
			// update失敗
			System.out.println("update失敗");
		}
		model.addAttribute("students", studao.queryAll());
		return "index";
	}

	/**
	 * 成績優秀者表示
	 *
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/displayGoodController")
	public String displayGoodScore(Model model) {
		String stuTmp = "";
		List<Student> studentList = getStudentList();
		BigDecimal average = getAverage(studentList);
		List<Student> returnList = getReturnList(studentList, average);
		model.addAttribute("students", returnList);
		return "index";
	}

	public List<Student> getStudentList() {
		StudentDao studao = (StudentDao) getStudentDao("studentdao");
		List<Student> studentList = new ArrayList<Student>();
		studentList = studao.queryAll();
		return studentList;
	}

	private BigDecimal getAverage(List<Student> studentList) {
		BigDecimal average = BigDecimal.ZERO;
		for (Student student : studentList) {
			average = average.add(new BigDecimal(student.getScore()));
		}

		return average.divide(new BigDecimal(studentList.size()), 2, RoundingMode.HALF_UP);

	}

	private List<Student> getReturnList(List<Student> studentList, BigDecimal average) {
		List<Student> returnList = new ArrayList<>();
		for (Student student : studentList) {
			if (new BigDecimal(student.getScore()).compareTo(average) > 0) {
				returnList.add(student);
			}
		}
		return returnList;
	}

	@RequestMapping(value = "/displayGokakuController")
	public String displayGokakuController(Model model) {
		List<Student> studentList = getStudentList();
		List<Student> returnList = getGokakuStudentList(studentList);
		model.addAttribute("students", returnList);
		return "index";
	}

	private List<Student> getGokakuStudentList(List<Student> studentList) {
		List<Student> returnList = new ArrayList<>();
		for (Student student : studentList) {
			if (student.getScore() >= 60) {
				returnList.add(student);
			}
		}
		return returnList;
	}

	@RequestMapping(value = "/displayAverScoreController")
	public String getAverScoreByClassId(Model model) {

		List<Student> studentList = getStudentList();

		List<ClassScoreForm> classScoreFormList = new ArrayList<>();
		Map<Integer, CountScoreDto> map = new HashMap<>();

		for (Student student : studentList) {
			int classid = student.getClassid();
			CountScoreDto countScoreDto = map.get(classid);

			if (countScoreDto == null) {
				countScoreDto = new CountScoreDto();
				countScoreDto.setClassId(classid);
				map.put(classid, countScoreDto);
			}

			countScoreDto.setCount(countScoreDto.getCount() + 1);
			countScoreDto.setSumScore(countScoreDto.getSumScore() + student.getScore());
		}

		for (CountScoreDto countScoreDto : map.values()) {

			BigDecimal averScore = new BigDecimal(countScoreDto.getSumScore())
					.divide(new BigDecimal(countScoreDto.getCount()), 2, RoundingMode.HALF_UP);
			// BigDecimal firstNum=new BigDecimal(countScoreDto.getSumScore());
			// BigDecimal secNum=new BigDecimal(countScoreDto.getCount());
			// BigDecimal averScore=firstNum.divide(secNum, 2, RoundingMode.HALF_UP);

			ClassScoreForm classScoreForm = new ClassScoreForm();
			classScoreForm.setClassId(countScoreDto.getClassId());
			classScoreForm.setAverScore(averScore.intValue());

			classScoreFormList.add(classScoreForm);
		}

		model.addAttribute("classScoreFormList", classScoreFormList);
		return "index";
	}

}