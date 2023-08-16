package kh.yhjsemi.academy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.academy.model.vo.SemiAcademyVo;
import kh.yhjsemi.academy.service.SemiAcademyService;
import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;

/**
 * Servlet implementation class SemiTeacherGetController
 */
@WebServlet("/sm/academy/get")
public class SemiAcademyGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiAcademyGetController() {
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
		String msg = (String) request.getSession().getAttribute("successFailMsg");
		if(msg != null) {
			request.setAttribute("msg", msg);
			request.getSession().removeAttribute("successFailMsg");
		}
		if (loginq != null) {
			if (loginq.getMtype().equals("A")) {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset= UTF-8");
				String mid = request.getParameter("mid");
				SemiAcademyService dao = new SemiAcademyService();
				List<SemiTeacherVo> vo = dao.selectOneAcademy(mid);
				List<SemiAcademyVo> vo1 = dao.selectListAcademy();
				request.setAttribute("semiteacherlist", vo);
				request.setAttribute("semiacademylist", vo1);

				request.getRequestDispatcher("/WEB-INF/view/semiacademy/academyget.jsp").forward(request, response);

			} else {
				response.sendRedirect(request.getContextPath() + "/sm/error");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
