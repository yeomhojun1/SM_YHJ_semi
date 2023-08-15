package kh.yhjsemi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.board.model.vo.SemiBoardVo;
import kh.yhjsemi.board.service.SemiBoardService;
import kh.yhjsemi.member.model.vo.SemiMemberVo;

@WebServlet("/sm/board/insert.do")
public class SemiBoardInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiBoardInsertDoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SemiMemberVo loginVo = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginVo.getMtype().isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/main");
		} else {
			if (loginVo.getMtype().equals("A")) {
				SemiBoardService service = new SemiBoardService();
				String bwriter = loginVo.getMname();
				String bwriterNo = loginVo.getMid();
				String btitle = request.getParameter("btitle");
				String bcontent = request.getParameter("bcontent");

				SemiBoardVo vo = new SemiBoardVo();
				vo.setBwriter(bwriter);
				vo.setBwriterNo(bwriterNo);
				vo.setBtitle(btitle);
				vo.setBcontent(bcontent);
				int result = service.insertboard(vo);
				if (result < 1) {
					request.getSession().setAttribute("msg", "글 등록 실패!");
					System.out.println(request.getSession().getAttribute("msg"));
				} else {
					request.getSession().setAttribute("msg", "글 등록 성공!!!!!");
					System.out.println(request.getSession().getAttribute("msg"));
				}
				response.sendRedirect(request.getContextPath() + "/sm/board/list");
			} else {
				System.out.println("권한이 없습니다");
				response.sendRedirect(request.getContextPath() + "/sm/error");
			}
		}
	}
}
//}