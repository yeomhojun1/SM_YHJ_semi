package kh.yhjsemi.student.model.vo;

public class SemiStudentVo {
	private String studentName;
	private String studentNo;
	private String grade;
	private String parentNumber;
	private String score;
	@Override
	public String toString() {
		return "SemiStudentVo [studentName=" + studentName + ", studentNo=" + studentNo + ", grade=" + grade
				+ ", parentNumber=" + parentNumber + ", score=" + score + "]";
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getParentNumber() {
		return parentNumber;
	}
	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
}
