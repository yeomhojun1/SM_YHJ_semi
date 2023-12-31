package kh.yhjsemi.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.member.service.SemiMemberService;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.student.service.SemiStudentService;

/**
 * Servlet implementation class SemiMemberListController
 */
@WebServlet("/sm/member/list")
public class SemiMemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiMemberListController() {
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
			request.setAttribute("msg", msg);
			request.getSession().removeAttribute("successFailMsg");
		}
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("A")) {
				SemiMemberService service = new SemiMemberService();
				List<SemiMemberVo> result = service.selectListMember();
				request.setAttribute("semimemberlist", result);
				request.getRequestDispatcher("/WEB-INF/view/semimember/member.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/sm/error");
				}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
		request.getSession().removeAttribute("msg");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
