package kh.yhjsemi.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;

/**
 * Servlet implementation class SemiHomeController
 */
@WebServlet("/sm/home")
public class SemiHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SemiMemberVo loginq = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginq != null) {
			if (loginq.getMtype().equals("A") ) {
				response.sendRedirect(request.getContextPath() + "/sm/member/list");
			}else if(loginq.getMtype().equals("T"))	{
				response.sendRedirect(request.getContextPath() + "/sm/teacher/get?mid="+loginq.getMid());
			}else if(loginq.getMtype().equals("S")) {
				response.sendRedirect(request.getContextPath() + "/sm/student/get?mid2="+loginq.getMid());
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
}
}
