package kh.yhjsemi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;

@WebServlet("/sm/board/insert")
public class SemiBoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiBoardInsertController() {
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
			if (loginq.getMtype().equals("A")) {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset= UTF-8");
				request.getRequestDispatcher("/WEB-INF/view/semiboard/boardinsert.jsp").forward(request, response);
			} else {
				System.out.println("권한이 없습니다");
				response.sendRedirect(request.getContextPath() + "/sm/error");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");

		}
	}

}
