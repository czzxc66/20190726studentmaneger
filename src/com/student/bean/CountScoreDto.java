package com.student.bean;

public class CountScoreDto {

	private int classId;

	private int count;

	private double sumScore;

	/**
	 * @return classId
	 */
	public int getClassId() {
		return classId;
	}

	/**
	 * @param classId セットする classId
	 */
	public void setClassId(int classId) {
		this.classId = classId;
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return sumScore
	 */
	public double getSumScore() {
		return sumScore;
	}

	/**
	 * @param sumScore セットする sumScore
	 */
	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
	}
}
