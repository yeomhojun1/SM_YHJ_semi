package kh.yhjsemi.student.model.vo;

import java.util.Date;

public class SemiStudentVo {
	private String mid2;
	private String studentName;
	private String examScore;
	private String birthday;
	private String enterDate;
	private String important;
	private String mid;
	private String tele;

	
	public SemiStudentVo(String mid2, String studentName, String examScore, String birthday, String enterDate,
			String important, String mid, String tele) {
		super();
		this.mid2 = mid2;
		this.studentName = studentName;
		this.examScore = examScore;
		this.birthday = birthday;
		this.enterDate = enterDate;
		this.important = important;
		this.mid = mid;
		this.tele = tele;
	}
	public SemiStudentVo() {
		super();
	}
	@Override
	public String toString() {
		return "SemiStudentVo [mid2=" + mid2 + ", studentName=" + studentName + ", examScore=" + examScore
				+ ", birthday=" + birthday + ", enterDate=" + enterDate + ", important=" + important + ", mid=" + mid
				+ ", tele=" + tele + "]";
	}
	public String getMid2() {
		return mid2;
	}
	public void setMid2(String mid2) {
		this.mid2 = mid2;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getExamScore() {
		return examScore;
	}
	public void setExamScore(String examScore) {
		this.examScore = examScore;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	public String getImportant() {
		return important;
	}
	public void setImportant(String important) {
		this.important = important;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	
	
	

	
}
