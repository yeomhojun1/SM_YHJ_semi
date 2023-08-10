package kh.yhjsemi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.member.service.SemiMemberService;

/**
 * Servlet implementation class SemiMemberInsertDoController
 */
@WebServlet("/sm/member/insert.do")
public class SemiMemberInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SemiMemberService service = new SemiMemberService();

	public SemiMemberInsertDoController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String mtype = request.getParameter("mtype");
		String mname= null;
		SemiMemberVo vo = new SemiMemberVo();

		vo.setMid(mid);
		vo.setMpwd(mpwd);
		vo.setMtype(mtype);
		vo.setMname(mname);
		int result = service.insertMember(vo);
		SemiMemberVo loginVo = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		System.out.println(loginVo);
		if (result < 1) {
			request.getSession().setAttribute("msg", "멤버 등록 실패!");
			System.out.println(request.getSession().getAttribute("msg"));
		} else {
			request.getSession().setAttribute("msg", "멤버 등록 되었습니다");
			System.out.println(request.getSession().getAttribute("msg"));
	
		response.sendRedirect(request.getContextPath() + "/sm/member/list");
	}

}
}
