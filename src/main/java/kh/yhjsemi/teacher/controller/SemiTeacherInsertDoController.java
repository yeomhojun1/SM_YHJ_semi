package kh.yhjsemi.teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.student.service.SemiStudentService;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;
import kh.yhjsemi.teacher.service.SemiTeacherService;

/**
 * Servlet implementation class SemiTeacherInsertDoController
 */
@WebServlet("/sm/teacher/insert.do")
public class SemiTeacherInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SemiTeacherService service = new SemiTeacherService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemiTeacherInsertDoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SemiMemberVo loginVo = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginVo == null) {
			request.getSession().setAttribute("successFailMsg", "로그인이 필요한 페이지입니다. 로그인 후 확인해주세요.");
			response.sendRedirect(request.getContextPath() + "/main");
			return;
		}

		String mid = request.getParameter("mid");
		String teacherName = request.getParameter("teacherName");
		String entranceDate = request.getParameter("entranceDate");
		String acaNo = request.getParameter("acaNo");

		SemiTeacherVo vo = new SemiTeacherVo();
		vo.setMid(mid);
		vo.setTeacherName(teacherName);
		vo.setEntranceDate(entranceDate);
		vo.setAcaNo(acaNo);

		int result = service.insertTeacher(vo);
		System.out.println(result);
		if (result < 1) {
			request.getSession().setAttribute("msg", "선생님 등록 실패!");
			System.out.println(request.getSession().getAttribute("msg"));
		} else {
			request.getSession().setAttribute("msg", teacherName + "선생님 등록 되었습니다");
			System.out.println(request.getSession().getAttribute("msg"));
		}
		if (loginVo.getMtype().equals("A")) {
			response.sendRedirect(request.getContextPath() + "/sm/academy/get?mid=" + loginVo.getMid());
		}else {
			response.sendRedirect(request.getContextPath() + "/sm/error");
			
		}
	}
}
