/**
 *
 */
package com.student.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixujiao
 *
 */
public class PrintStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//新規studentOne
		Student studentOne=new Student();
		studentOne.setId(1);
		studentOne.setName("zhang");
		studentOne.setAge(20);
		studentOne.setBirthday("1998/12/08");
		studentOne.setScore(98);
		studentOne.setClassid(1);
		Student studentTwo=new Student(2,"wang","1995/03/05",23,90,2,"");
		Student studentThree=new Student(3,"li","1992/07/07",26,97,1,"");
		Student studentFour=new Student(4,"zhao","1999/10/05",19,93,2,"");

//		System.out.println(studentOne);
//		System.out.println(studentTwo);
//		System.out.println(studentThree);
//		System.out.println(studentFour);


		//新規list studentlist
		//List<クラスの名前>studentList=new ArrayList<クラスの名前>()
		List<Student> studentList=new ArrayList<Student>();
		studentList.add(studentOne);
		studentList.add(studentTwo);
		studentList.add(studentThree);
		studentList.add(studentFour);

//
//		System.out.println("studentList"+studentList);
//
//		double sumStudentScore=GetsumStudentScore(studentList);
//		System.out.println("学生の成績の合計:"+ sumStudentScore);
//
//		double minStudentScore=GetminStudentScore(studentList);
//		System.out.println("学生の成績max:"+ minStudentScore);


	Map<String,Student>studentMap=new HashMap<>();
	studentMap.put("1", studentOne);
	studentMap.put("2", studentTwo);
	studentMap.put("3", studentThree);
	studentMap.put("4", studentFour);
//	System.out.println(studentMap);
	double sumStudentScoreMap=GetsumStudentScoreMap(studentMap);
	System.out.println("学生の成績の合計Map:"+ sumStudentScoreMap);

	double sumStudentAgeMap=GetsumStudentAgeMap(studentMap);
	System.out.println("学生の年齢の合計Map:"+ sumStudentAgeMap);

	double maxStudentScoreMap=GetmaxStudentScoreMap(studentMap);
	System.out.println("学生の成績のmaxMap:"+ maxStudentScoreMap);

	double minStudentScoreMap=GetinStudentScoreMap(studentMap);
	System.out.println("学生の成績のminMap:"+ minStudentScoreMap);



	}
/**
 * 学生成績合計Map
 * @param stuMap
 * @return
 */
	private static double GetsumStudentScoreMap(Map<String,Student>stuMap) {
		//変数初期化
		double sumStudentScoreMap=0;
			for(Student stu:stuMap.values()) {
				sumStudentScoreMap=sumStudentScoreMap+stu.getScore();
			}

		return sumStudentScoreMap;
	}
/**
 *学生年齢合計Map
 * @param stuMap
 * @return
 */
	private static double GetsumStudentAgeMap(Map<String,Student>stuMap) {
		//変数初期化
		double sumStudentAgeMap=0;
			for(Student stu:stuMap.values()) {
				sumStudentAgeMap=sumStudentAgeMap+stu.getAge();
			}

		return sumStudentAgeMap;
	}
/**
 *学生成績の最高点Map
 * @param stuMap
 * @return
 */
	private static double GetmaxStudentScoreMap(Map<String,Student>stuMap) {
		//変数初期化
		double maxStudentScoreMap=0;
			for(Student stu:stuMap.values()) {
				if(maxStudentScoreMap<stu.getScore()) {
					maxStudentScoreMap=stu.getScore();
				}
			}

		return maxStudentScoreMap;
	}
/**
 * 学生成績の最低点Map
 * @param stuMap
 * @return
 */
	private static double GetinStudentScoreMap(Map<String,Student>stuMap) {
		double minStudentScoreMap=0;
		for(Student stu:stuMap.values()) {
			if(stu.getId()==1) {
				minStudentScoreMap=stu.getScore();
			}else {
				if(minStudentScoreMap>stu.getScore()) {
					minStudentScoreMap=stu.getScore();
				}
			}
				}
		return minStudentScoreMap;

	}
/**
 *学生成績合計
 * @param stuList
 * @return
 */
//private static double GetsumStudentScore(List<Student> stuList) {
//	//変数初期化
//	double sumScore=0;
//		for(Student stu:stuList) {
//			sumScore=sumScore+stu.getScore();
//		}
//
//	return sumScore;
//
//}
///**
// * 学生成績の最低点
// * @param stuList
// * @return
// */
//private static double GetminStudentScore(List<Student> stuList) {
//	double minScore=0;
//	for(Student stu:stuList) {
//		if(stu.getId()==1) {
//			minScore=stu.getScore();
//		}else {
//			if(minScore>stu.getScore()) {
//				minScore=stu.getScore();
//			}
//		}
//			}
//	return minScore;
//
//}


}
