package kh.yhjsemi.member.model.vo;

public class SemiMemberVo {
	private String mid;
	private String mpwd;
	private String mtype;
	public SemiMemberVo(String mid, String mpwd) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
	}
	public SemiMemberVo(String mid, String mpwd,String mtype) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.mtype = mtype;
	}
	public SemiMemberVo() {
		super();
	}
	@Override
	public String toString() {
		return "SemiMemberVo [mid=" + mid + ", mpwd=" + mpwd + ", mtype=" + mtype + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
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
	
}
