package kh.yhjsemi.teacher.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.teacher.service.SemiTeacherService;

/**
 * Servlet implementation class SemiStudentGetController
 */
@WebServlet("/sm/teacher/get")
public class SemiTeacherGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiTeacherGetController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = (String) request.getSession().getAttribute("successFailMsg");
		if(msg != null) {
			request.getSession().removeAttribute("successFailMsg");
			request.setAttribute("msg", msg);
		}
		
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("A") || loginq.getMtype().equals("T")) {
				String mid = request.getParameter("mid");
				SemiTeacherService dao = new SemiTeacherService();
				List<SemiStudentVo> vo = dao.selectOneTeacher(mid);
				request.setAttribute("mid", vo);
				request.getRequestDispatcher("/WEB-INF/view/semiteacher/teacherget.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/sm/error");			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
	}

}
