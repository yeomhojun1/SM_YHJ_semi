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
 * Servlet implementation class SemiMemberLoginController
 */
@WebServlet("/sm/login")
public class SemiMemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiMemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset= UTF-8");
		String sendUrl= request.getContextPath();

		String meid= request.getParameter("meid");
		String mpwd= request.getParameter("mpwd");
		String mtype= request.getParameter("mtype");
		SemiMemberVo vo = new SemiMemberVo(meid,mpwd, mtype);
		SemiMemberVo result= new SemiMemberService().login(vo);
		
		System.out.println("잘 들어오는가");
		if(result != null) {
			request.getSession().setAttribute("loginVo", result);
			if(mtype.equals("T")) {
				request.getSession().setAttribute("successFailMsg", "선생님 환영합니다");
				sendUrl += "/sm/teacher/get?mid="+meid;
			}else if(mtype.equals("S")) {
				request.getSession().setAttribute("successFailMsg", " 학생 환영합니다");
				sendUrl += "/sm/student/get?mid2="+meid;
			}else if(mtype.equals("A")) {
				request.getSession().setAttribute("successFailMsg", "어휴 물주님 어서오세요");
				sendUrl += "/sm/academy/get?mid="+meid;
			}
		} else {
			request.getSession().setAttribute("successFailMsg", "로그인 실패하였습니다.\n 아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
			sendUrl += "/main";
		}
		response.sendRedirect(sendUrl);
	}
}
