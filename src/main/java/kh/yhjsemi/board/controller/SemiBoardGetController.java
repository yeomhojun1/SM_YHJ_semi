package kh.yhjsemi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.board.model.vo.SemiBoardVo;
import kh.yhjsemi.board.service.SemiBoardService;

@WebServlet("/sm/board/bcontent")
public class SemiBoardGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SemiBoardGetController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bnoStr = request.getParameter("bno");
		int bno = 0;
		try {
			bno = Integer.parseInt(bnoStr);
		} catch (Exception e) {
		}
		SemiBoardService dao = new SemiBoardService();
		SemiBoardVo vo = dao.selectOneboard(bno);
		request.setAttribute("bcontent", vo);
		request.getRequestDispatcher("/WEB-INF/view/semiboard/bcontent.jsp").forward(request, response);
	}

}
