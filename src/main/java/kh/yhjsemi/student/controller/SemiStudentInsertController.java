package kh.yhjsemi.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;

/**
 * Servlet implementation class SemiStudentInsertController
 */
@WebServlet("/sm/student/insert")
public class SemiStudentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiStudentInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("A") || loginq.getMtype().equals("T")) {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset= UTF-8");
				request.getRequestDispatcher("/WEB-INF/view/semistudent/insertStudent.jsp").forward(request, response);

			} else {
				System.out.println("권한이 없습니다");
				response.sendRedirect(request.getContextPath() + "/sm/student/list");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
	}
}