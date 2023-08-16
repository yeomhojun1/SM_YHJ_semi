package kh.yhjsemi.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.student.model.dao.SemiStudentDao;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.student.service.SemiStudentService;

/**
 * Servlet implementation class SemiStudentListController
 */
@WebServlet("/sm/student/list")
public class SemiStudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiStudentListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String searchword= request.getParameter("searchword");
		request.getSession().removeAttribute("msg");
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("T") || loginq.getMtype().equals("A")) {
				SemiStudentService service = new SemiStudentService();
				List<SemiStudentVo> result = service.selectListStudent();

				request.setAttribute("semistudentlist", result);
				// request.setAttribute("searchword", searchword);

				request.getRequestDispatcher("/WEB-INF/view/semistudent/student.jsp").forward(request, response);

			} else {
				response.sendRedirect(request.getContextPath() + "/sm/student/get?mid2="+loginq.getMid());
			}
		}else {
			
			response.sendRedirect(request.getContextPath() + "/main");
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
	}
}
