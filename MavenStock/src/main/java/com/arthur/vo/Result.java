package com.arthur.vo;

public class Result {
	private String ID;
	private String first;
	private String second;
	private String third;
	private String four;
	private String five;
	private String six;
	private String seven;
	private String eight;
	private int total;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getThird() {
		return third;
	}
	public void setThird(String third) {
		this.third = third;
	}
	public String getFour() {
		return four;
	}
	public void setFour(String four) {
		this.four = four;
	}
	public String getFive() {
		return five;
	}
	public void setFive(String five) {
		this.five = five;
	}
	public String getSix() {
		return six;
	}
	public void setSix(String six) {
		this.six = six;
	}
	public String getSeven() {
		return seven;
	}
	public void setSeven(String seven) {
		this.seven = seven;
	}
	public String getEight() {
		return eight;
	}
	public void setEight(String eight) {
		this.eight = eight;
	}
	@Override
	public String toString() {
		return "Result [ID=" + ID + ", first=" + first + ", second=" + second + ", third=" + third + ", four=" + four
				+ ", five=" + five + ", six=" + six + ", seven=" + seven + ", eight=" + eight + ", total=" + total
				+ "]";
	}
	
	
}
