package kh.yhjsemi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.board.service.SemiBoardService;
import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.student.service.SemiStudentService;

/**
 * Servlet implementation class SemiBoardDeleteController
 */
@WebServlet("/sm/board/delete")
public class SemiBoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SemiMemberVo loginVo = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		String bnoStr = request.getParameter("bno");
		System.out.println(bnoStr);
		int bno = 0;
		int result = 0;
		SemiBoardService service = new SemiBoardService();
		if (loginVo != null) {
			if (loginVo.getMtype().equals("A")) {
				try {
					bno = Integer.parseInt(bnoStr);
					result = service.deleteboard(bno);
				} catch (Exception e) {
				}
				if (result < 1) {
					request.getSession().setAttribute("bmsg", "글 삭제 실패!");
					System.out.println(request.getSession().getAttribute("bmsg"));
				} else {
					request.getSession().setAttribute("bmsg", "글 삭제 되었습니다");
					System.out.println(request.getSession().getAttribute("bmsg"));
				}
				response.sendRedirect(request.getContextPath() + "/sm/board/list");
			} else {
				response.sendRedirect(request.getContextPath() + "/sm/error");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
	}
}
