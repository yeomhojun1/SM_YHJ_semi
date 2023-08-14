package kh.yhjsemi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;

/**
 * Servlet implementation class SemiMemberInsertController
 */
@WebServlet("/sm/member/insert")
public class SemiMemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiMemberInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset= UTF-8");
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("A")) {
				request.getRequestDispatcher("/WEB-INF/view/semimember/insertmember.jsp").forward(request, response);
			} else {
				System.out.println("권한이 없습니다");
				response.sendRedirect(request.getContextPath() + "/student/list");
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

	}

}
