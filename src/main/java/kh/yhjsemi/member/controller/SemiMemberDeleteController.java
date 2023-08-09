package kh.yhjsemi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.member.service.SemiMemberService;
import kh.yhjsemi.student.service.SemiStudentService;

/**
 * Servlet implementation class SemiMemberDeleteController
 */
@WebServlet("/sm/member/delete")
public class SemiMemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiMemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset= UTF-8");
		String mid = request.getParameter("mid");
		SemiMemberService service = new SemiMemberService();
		int result = service.deleteMember(mid);
		if(result <1) {
			request.getSession().setAttribute("msg", "멤버 삭제 실패!");
			System.out.println(request.getSession().getAttribute("msg"));
		}else {
			request.getSession().setAttribute("msg", "멤버 삭제 되었습니다");
			System.out.println(request.getSession().getAttribute("msg"));
		}
		SemiMemberVo loginVo = (SemiMemberVo)request.getSession().getAttribute("loginVo");
		if(loginVo == null ) {
			response.sendRedirect(request.getContextPath()+"/main");
		}else {
			response.sendRedirect(request.getContextPath()+"/sm/member/list");
		}
	}

}
