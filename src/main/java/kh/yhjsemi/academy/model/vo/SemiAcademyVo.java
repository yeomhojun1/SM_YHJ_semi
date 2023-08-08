package kh.yhjsemi.academy.model.vo;

import java.sql.Date;

public class SemiAcademyVo {
	private String acaNo;
	private String acaAddress;
	private String acaName;
	private String acaPhone;
	@Override
	public String toString() {
		return "SemiAcademyVo [acaNo=" + acaNo + ", acaAddress=" + acaAddress + ", acaName=" + acaName + ", acaPhone="
				+ acaPhone + "]";
	}
	public String getAcaNo() {
		return acaNo;
	}
	public void setAcaNo(String acaNo) {
		this.acaNo = acaNo;
	}
	public String getAcaAddress() {
		return acaAddress;
	}
	public void setAcaAddress(String acaAddress) {
		this.acaAddress = acaAddress;
	}
	public String getAcaName() {
		return acaName;
	}
	public void setAcaName(String acaName) {
		this.acaName = acaName;
	}
	public String getAcaPhone() {
		return acaPhone;
	}
	public void setAcaPhone(String acaPhone) {
		this.acaPhone = acaPhone;
	}
	public SemiAcademyVo(String acaNo, String acaAddress, String acaName, String acaPhone) {
		super();
		this.acaNo = acaNo;
		this.acaAddress = acaAddress;
		this.acaName = acaName;
		this.acaPhone = acaPhone;
	}
	public SemiAcademyVo(String acaNo) {
		super();
		this.acaNo = acaNo;
	}
	public SemiAcademyVo() {
		super();
	}
	
	
	
}
