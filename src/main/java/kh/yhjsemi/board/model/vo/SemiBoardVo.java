package kh.yhjsemi.board.model.vo;


public class SemiBoardVo {
	private int bno;
	private String bwriter;
	private String bwriterNo;
	private String btitle;
	private String bcontent;
	@Override
	public String toString() {
		return "SemiBoardVo [bno=" + bno + ", bwriter=" + bwriter + ", bwriterNo=" + bwriterNo + ", btitle=" + btitle
				+ ", bcontent=" + bcontent + "]";
	}
	public SemiBoardVo(int bno, String bwriter, String bwriterNo, String btitle, String bcontent) {
		super();
		this.bno = bno;
		this.bwriter = bwriter;
		this.bwriterNo = bwriterNo;
		this.btitle = btitle;
		this.bcontent = bcontent;
	}
	public SemiBoardVo(int bno, String bwriter, String btitle) {
		super();
		this.bno = bno;
		this.bwriter = bwriter;
		this.btitle = btitle;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBwriterNo() {
		return bwriterNo;
	}
	public void setBwriterNo(String bwriterNo) {
		this.bwriterNo = bwriterNo;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public SemiBoardVo() {
		super();
	}
	
}
