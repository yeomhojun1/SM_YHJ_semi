package kh.yhjsemi.student.model.vo;

public class SemiStudentVo {
	private String studentNo;
	private String studentName;
	private int age;
	private String parentNumber;
	@Override
	public String toString() {
		return "SemiStudentVo [studentNo=" + studentNo + ", studentName=" + studentName + ", age=" + age
				+ ", parentNumber=" + parentNumber + "]";
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getParentNumber() {
		return parentNumber;
	}
	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}
	
	

	
}
