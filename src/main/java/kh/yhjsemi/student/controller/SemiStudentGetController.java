package kh.yhjsemi.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.student.service.SemiStudentService;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

/**
 * Servlet implementation class SemiWeekGetController
 */
@WebServlet("/sm/student/get")
public class SemiStudentGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiStudentGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SemiMemberVo loginq = (SemiMemberVo)request.getSession().getAttribute("loginVo");
		String msg = (String) request.getSession().getAttribute("successFailMsg");
		if(msg != null) {
			request.getSession().removeAttribute("successFailMsg");
			request.setAttribute("msg", msg);
		}
		if(loginq !=null) {
		String mid2 = request.getParameter("mid2");
		SemiStudentService dao= new SemiStudentService();
		List<SemiWeekVo> vo = dao.selectOneStudent(mid2);
	request.setAttribute("mid2", vo);
		request.getRequestDispatcher("/WEB-INF/view/semistudent/studentget.jsp").forward(request, response);
	}else {
		response.sendRedirect(request.getContextPath() + "/sm/error");
	
	}
	}



}
