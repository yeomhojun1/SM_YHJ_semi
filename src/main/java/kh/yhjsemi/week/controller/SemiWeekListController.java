package kh.yhjsemi.week.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.week.model.vo.SemiWeekVo;
import kh.yhjsemi.week.service.SemiWeekService;

/**
 * Servlet implementation class SemiWeekListController
 */
@WebServlet("/sm/week/list")
public class SemiWeekListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiWeekListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SemiWeekService service = new SemiWeekService();
		List<SemiWeekVo> result = service.selectListWeek();
		request.setAttribute("semiweeklist", result);
		request.getRequestDispatcher("/WEB-INF/view/semiweek/week.jsp").forward(request, response);
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
