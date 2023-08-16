package kh.yhjsemi.teacher.model.vo;

import java.sql.Date;

public class SemiTeacherVo {
	private String mid;
	private String teacherName;
	private String entranceDate;
	private String acaNo;
	@Override
	public String toString() {
		return "SemiTeacherVo [mid=" + mid + ", teacherName=" + teacherName + ", entranceDate=" + entranceDate
				+ ", acaNo=" + acaNo + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}
	public String getAcaNo() {
		return acaNo;
	}
	public void setAcaNo(String acaNo) {
		this.acaNo = acaNo;
	}
	public SemiTeacherVo(String mid, String teacherName, String entranceDate, String acaNo) {
		super();
		this.mid = mid;
		this.teacherName = teacherName;
		this.entranceDate = entranceDate;
		this.acaNo = acaNo;
	}
	public SemiTeacherVo() {
		super();
	}
	
}
