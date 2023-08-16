package kh.yhjsemi.week.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;
import kh.yhjsemi.teacher.service.SemiTeacherService;
import kh.yhjsemi.week.model.vo.SemiWeekVo;
import kh.yhjsemi.week.service.SemiWeekService;

/**
 * Servlet implementation class SemiWeekInsertDoController
 */
@WebServlet("/sm/week/insert.do")
public class SemiWeekInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SemiWeekService service = new SemiWeekService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiWeekInsertDoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SemiMemberVo loginVo = (SemiMemberVo) request.getSession().getAttribute("loginVo");
		if (loginVo == null) {
			request.getSession().setAttribute("successFailMsg", "로그인이 필요한 페이지입니다. 로그인 후 확인해주세요.");
			response.sendRedirect(request.getContextPath() + "/main");
			return;
		}

		String monthNoStr = request.getParameter("year")+request.getParameter("month")+request.getParameter("week");
		String tcid = request.getParameter("tc_id");
		String stid = request.getParameter("st_id");
		String expect = request.getParameter("expect");
		String study = request.getParameter("study");
		String stComment = request.getParameter("stComment");
		String acheive = request.getParameter("acheive");
		String weekScoreStr = request.getParameter("week_Score");
		String studentName = request.getParameter("student_Name");

		int weekScore=Integer.parseInt(weekScoreStr);
		int monthNo = Integer.parseInt(monthNoStr);
		SemiWeekVo vo = new SemiWeekVo();
		vo.setMonthNo(monthNo);
		vo.setTcid(tcid);
		vo.setStid(stid);
		vo.setExpect(expect);
		vo.setStudy(study);
		vo.setStComment(stComment);
		vo.setAcheive(acheive);
		vo.setWeekScore(weekScore);
		vo.setStudentName(studentName);

		int result = service.insertWeek(vo);
		System.out.println(result);
		if (result < 1) {
			request.getSession().setAttribute("msg", "주차별 진도 등록 실패!");
			System.out.println(request.getSession().getAttribute("msg"));
		} else {
			request.getSession().setAttribute("msg", monthNo + "주차별 진도 등록 되었습니다");
			System.out.println(request.getSession().getAttribute("msg"));
		}
		if (loginVo.getMtype().equals("A")) {
			response.sendRedirect(request.getContextPath() + "/sm/academy/get?mid=" + loginVo.getMid());
		}else {
			response.sendRedirect(request.getContextPath() + "/sm/error");
			
		}
	}

}
