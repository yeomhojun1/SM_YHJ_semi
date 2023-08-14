package kh.yhjsemi.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.student.service.SemiStudentService;
import kh.yhjsemi.teacher.service.SemiTeacherService;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

/**
 * Servlet implementation class SemiStudentGetController
 */
@WebServlet("/sm/teacher/get")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("A") || loginq.getMtype().equals("T")) {
				String mid = request.getParameter("mid");
				SemiTeacherService dao = new SemiTeacherService();
				List<SemiStudentVo> vo = dao.selectOneTeacher(mid);
				request.setAttribute("mid", vo);
				request.getRequestDispatcher("/WEB-INF/view/semiteacher/teacherget.jsp").forward(request, response);
			} else {
				System.out.println("권한이 없습니다");
				response.sendRedirect(request.getContextPath() + "/sm/student/list");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
	}

}
