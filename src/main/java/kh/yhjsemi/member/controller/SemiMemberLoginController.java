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
		String mid= request.getParameter("mid");
		String mpwd= request.getParameter("mpwd");
		String mtype= request.getParameter("mtype");
		SemiMemberVo vo = new SemiMemberVo(mid,mpwd);
		String sendUrl= request.getContextPath();
		String result = new SemiMemberService().login(mid);
		SemiMemberVo result1= new SemiMemberService().login(mid,mtype);
		System.out.println(result);
		System.out.println(result1);
		
		if(mtype.equals("t")) {
			if(mpwd.equals(result)) {
			request.setAttribute("loginid", mid);
			request.getSession().setAttribute("SsLoginId", result1.getMname());
			request.getSession().setAttribute("successFailMsg", "선생님 환영합니다");
			sendUrl += "/sm/teacher/get?mid="+mid;
		}else {
			request.getSession().setAttribute("successFailMsg", "로그인 실패하였습니다.\n 아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
			sendUrl += "/main";
		}
		}else if(mtype.equals("s")) {
			if(mpwd.equals(result)) {
				request.setAttribute("loginid", mid);
				request.getSession().setAttribute("SsLoginId", result1.getMname());
				request.getSession().setAttribute("successFailMsg", " 학생 환영합니다");
				sendUrl += "/sm/student/get?mid2="+mid;
			}else {
				request.getSession().setAttribute("successFailMsg", "로그인 실패하였습니다.\n 아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
				
				
				sendUrl += "/main";
		}
		
	}else {
		System.out.println("아이디와 비밀먼호 확인해주세요");
	}
//		System.out.println(result);
//		System.out.println(mid);
//		System.out.println(mpwd);
//		System.out.println(mtype);
//		System.out.println(vo);
//		System.out.println(sendUrl);
//		System.out.println(result);
		response.sendRedirect(sendUrl);
//		System.out.println(sendUrl);
	}
}
