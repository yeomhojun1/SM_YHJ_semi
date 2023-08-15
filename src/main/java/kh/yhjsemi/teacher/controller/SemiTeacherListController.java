package kh.yhjsemi.teacher.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;
import kh.yhjsemi.teacher.service.SemiTeacherService;

/**
 * Servlet implementation class SemiTeacherListController
 */
@WebServlet("/sm/teacher/list")
public class SemiTeacherListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiTeacherListController() {
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
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset= UTF-8");
				SemiTeacherService service = new SemiTeacherService();
				List<SemiTeacherVo> result = service.selectListTeacher();
				request.setAttribute("semiteacherlist", result);
				request.getRequestDispatcher("/WEB-INF/view/semiteacher/teacher.jsp").forward(request, response);
			} else {
				System.out.println("권한이 없습니다");
				response.sendRedirect(request.getContextPath() + "/sm/error");			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
	}
}
