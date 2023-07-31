package kh.yhjsemi.week.model.vo;

import java.sql.Date;

public class SemiWeekVo {
		private Date yymmdd;
		private String tcid;
		private String stid;
		private String expect;
		private String study;
		private String stComment;
		private String acheive;
		private int weekScore;
		@Override
		public String toString() {
			return "SemiWeekVo [yymmdd=" + yymmdd + ", tcid=" + tcid + ", stid=" + stid + ", expect=" + expect
					+ ", study=" + study + ", stComment=" + stComment + ", acheive=" + acheive + ", weekScore="
					+ weekScore + "]";
		}
		public Date getYymmdd() {
			return yymmdd;
		}
		public void setYymmdd(Date yymmdd) {
			this.yymmdd = yymmdd;
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
		
		
		
		
}
