package kh.yhjsemi.week.model.vo;

import java.sql.Date;

public class SemiWeekVo {
		private int monthNo;
		private String tcid;
		private String stid;
		private String expect;
		private String study;
		private String stComment;
		private String acheive;
		private int weekScore;
		private String studentName;
		@Override
		public String toString() {
			return "SemiWeekVo [monthNo=" + monthNo + ", tcid=" + tcid + ", stid=" + stid + ", expect=" + expect
					+ ", study=" + study + ", stComment=" + stComment + ", acheive=" + acheive + ", weekScore="
					+ weekScore + ", studentName=" + studentName + "]";
		}
		public SemiWeekVo(int monthNo, String tcid, String stid, String expect, String study, String stComment,
				String acheive, int weekScore, String studentName) {
			super();
			this.monthNo = monthNo;
			this.tcid = tcid;
			this.stid = stid;
			this.expect = expect;
			this.study = study;
			this.stComment = stComment;
			this.acheive = acheive;
			this.weekScore = weekScore;
			this.studentName = studentName;
		}
	
		public SemiWeekVo() {
			super();
		}
		public int getMonthNo() {
			return monthNo;
		}
		public void setMonthNo(int monthNo) {
			this.monthNo = monthNo;
		}
		public String getTcid() {
			return tcid;
		}
		public void setTcid(String tcid) {
			this.tcid = tcid;
		}
		public String getStid() {
			return stid;
		}
		public void setStid(String stid) {
			this.stid = stid;
		}
		public String getExpect() {
			return expect;
		}
		public void setExpect(String expect) {
			this.expect = expect;
		}
		public String getStudy() {
			return study;
		}
		public void setStudy(String study) {
			this.study = study;
		}
		public String getStComment() {
			return stComment;
		}
		public void setStComment(String stComment) {
			this.stComment = stComment;
		}
		public String getAcheive() {
			return acheive;
		}
		public void setAcheive(String acheive) {
			this.acheive = acheive;
		}
		public int getWeekScore() {
			return weekScore;
		}
		public void setWeekScore(int weekScore) {
			this.weekScore = weekScore;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		
		
		
		
		
		
}
