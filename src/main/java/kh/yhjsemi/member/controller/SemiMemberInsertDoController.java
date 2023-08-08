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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset= UTF-8");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String mtype = request.getParameter("mtype");
		SemiMemberVo vo = new SemiMemberVo();

		vo.setMid(mid);
		vo.setMpwd(mpwd);
		vo.setMtype(mtype);
		int result = service.insertMember(vo);
		SemiMemberVo loginVo = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		System.out.println(result);
		if (result < 1) {
			request.getSession().setAttribute("msg", "멤버 등록 실패!");
			System.out.println(request.getSession().getAttribute("msg"));
		} else {
			request.getSession().setAttribute("msg", "멤버 등록 되었습니다");
			System.out.println(request.getSession().getAttribute("msg"));
		}
		if(loginVo.getMtype().equals("S")) {
			response.sendRedirect(request.getContextPath() + "/sm/student/get?mid2=" + loginVo.getMid());
		}else if(loginVo.getMtype().equals("T"))
		response.sendRedirect(request.getContextPath() + "/sm/teacher/get?mid=" + loginVo.getMid());

	}

}
