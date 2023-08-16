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

@WebServlet("/sm/board/list")
public class SemiBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SemiBoardListController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset= UTF-8");
		SemiBoardService service = new SemiBoardService();
		List<SemiBoardVo> result = service.selectListboard();
		
		request.setAttribute("semiboardlist", result);
		request.getSession().removeAttribute("msg");
		request.getRequestDispatcher("/WEB-INF/view/semiboard/board.jsp").forward(request, response);
	}


}
