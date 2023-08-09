package kh.yhjsemi.member.model.vo;

public class SemiMemberVo {
	private String meid;
	private String mpwd;
	private String mtype;
	private String mname;
	
	public SemiMemberVo() {
		super();
	}
	public SemiMemberVo(String meid, String mpwd) {
		super();
		this.meid = meid;
		this.mpwd = mpwd;
	}
	public SemiMemberVo(String meid, String mpwd,String mtype, String mname) {
		super();
		this.meid = meid;
		this.mpwd = mpwd;
		this.mtype = mtype;
		this.mname= mname;
	}
	
	
	public SemiMemberVo(String meid,String mpwd,String mtype) {
		super();
		this.meid = meid;
		this.mname = mname;
		this.mtype = mtype;
	}
	@Override
	public String toString() {
		return "SemiMemberVo [meid=" + meid + ", mpwd=" + mpwd + ", mtype=" + mtype + ", mname=" + mname + "]";
	}

	public String getMid() {
		return meid;
	}
	public void setMid(String meid) {
		this.meid = meid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}

	
}
