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

/**
 * Servlet implementation class SemiStudentSearchController
 */
@WebServlet("/sm/student/search")
public class SemiStudentSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiStudentSearchController() {
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
			if (loginq.getMtype().equals("T") || loginq.getMtype().equals("A")) {
				String searchword = request.getParameter("searchword");
					if(searchword !=null|| searchword=="") {
				SemiStudentService dao = new SemiStudentService();
				List<SemiStudentVo> vo = dao.selectsearchStudent(searchword);
				System.out.println(vo);
				request.setAttribute("searchword", vo);
				request.setAttribute("s", searchword);
				request.getRequestDispatcher("/WEB-INF/view/semistudent/studentsearch.jsp").forward(request, response);
					}else {
						response.sendRedirect(request.getContextPath() + "/sm/errorsearch");	
					}
			}else {
				response.sendRedirect(request.getContextPath() + "/sm/error");	
			}
		}
	}

}
