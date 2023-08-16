package kh.yhjsemi.week.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;

/**
 * Servlet implementation class SemiWeekInsertController
 */
@WebServlet("/sm/week/insert")
public class SemiWeekInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiWeekInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("T") ) {
				request.getRequestDispatcher("/WEB-INF/view/semiweek/insertWeek.jsp").forward(request, response);

			} else {
				response.sendRedirect(request.getContextPath() + "/sm/error");			}
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
	}
	


}
