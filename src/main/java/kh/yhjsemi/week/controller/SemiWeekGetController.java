package kh.yhjsemi.week.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.student.service.SemiStudentService;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

/**
 * Servlet implementation class SemiWeekGetController
 */
@WebServlet("/sm/student/get")
public class SemiWeekGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiWeekGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid2 = request.getParameter("mid2");
		System.out.println(mid2);
		//2. 전달받은 데이터를 활용해 DB학생 상세정보 가져오기
		SemiStudentService dao= new SemiStudentService();
		List<SemiWeekVo> vo = dao.selectOneStudent(mid2);
		System.out.println(vo);
	request.setAttribute("mid2", vo);
		request.getRequestDispatcher("/WEB-INF/view/semistudent/studentget.jsp").forward(request, response);
	}



}
