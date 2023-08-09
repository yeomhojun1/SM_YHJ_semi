package kh.yhjsemi.board.model.vo;


public class SemiBoardVo {
	private int bno;
	private String bwriter;
	private String bwriter_no;
	private String btitle;
	private String bcontent;
	@Override
	public String toString() {
		return "SemiBoardVo [bno=" + bno + ", BWRITER=" + bwriter + ", BWRITER_NO=" + bwriter_no + ", BTITLE=" + btitle
				+ ", BCONTENT=" + bcontent + "]";
	}
	public SemiBoardVo(int bno, String bWRITER, String bWRITER_NO, String bTITLE, String bCONTENT) {
		super();
		this.bno = bno;
		bwriter = bWRITER;
		bwriter_no = bWRITER_NO;
		btitle = bTITLE;
		bcontent = bCONTENT;
	}
	public SemiBoardVo() {
		super();
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBWRITER() {
		return bwriter;
	}
	public void setBWRITER(String bWRITER) {
		bwriter = bWRITER;
	}
	public String getBWRITER_NO() {
		return bwriter_no;
	}
	public void setBWRITER_NO(String bWRITER_NO) {
		bwriter_no = bWRITER_NO;
	}
	public String getBTITLE() {
		return btitle;
	}
	public void setBTITLE(String btitle) {
		btitle = btitle;
	}
	public String getBCONTENT() {
		return bcontent;
	}
	public void setBCONTENT(String bCONTENT) {
		bcontent = bCONTENT;
	}
}
