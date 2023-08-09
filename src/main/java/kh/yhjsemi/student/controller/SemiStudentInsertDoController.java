package kh.yhjsemi.student.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.student.service.SemiStudentService;

/**
 * Servlet implementation class SemiStudentInsertDoController
 */
@WebServlet("/sm/student/insert.do")
public class SemiStudentInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SemiStudentService service = new SemiStudentService();
   
    public SemiStudentInsertDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset= UTF-8");
		SemiMemberVo loginVo = (SemiMemberVo)request.getSession().getAttribute("loginVo");
		if(loginVo == null) {
			request.getSession().setAttribute("successFailMsg", "로그인이 필요한 페이지입니다. 로그인 후 확인해주세요.");
			response.sendRedirect(request.getContextPath()+"/main");
			return;
		}
		
		
		String mid2 = request.getParameter("mid2");
		String studentName = request.getParameter("studentName");
		String examScoreStr = request.getParameter("examScore");
		String birthday = request.getParameter("birthday");
		String enterDate = request.getParameter("enterDate");
		String important = request.getParameter("important");
		String mid = request.getParameter("mid");
		String tele = request.getParameter("tele");
		SemiStudentVo vo = new SemiStudentVo();
		vo.setMid2(mid2);
		vo.setStudentName(studentName);
		vo.setExamScore(examScoreStr);
		vo.setBirthday(birthday);
		vo.setEnterDate(enterDate);
		vo.setImportant(important);
		vo.setMid(mid);
		vo.setTele(tele);
		int result = service.insertStudent(vo);
System.out.println(result);
		if(result <1) {
			request.getSession().setAttribute("msg", "학생 등록 실패!");
			System.out.println(request.getSession().getAttribute("msg"));
		}else {
			request.getSession().setAttribute("msg", studentName+"학생 등록 되었습니다");
			System.out.println(request.getSession().getAttribute("msg"));
		}
		if(loginVo.getMtype().equals("T")) {
			response.sendRedirect(request.getContextPath()+"/sm/teacher/get?mid="+loginVo.getMid());
			}else if(loginVo.getMtype().equals("A")) {
				response.sendRedirect(request.getContextPath()+"/sm/academy/get?mid="+loginVo.getMid());
			}
	}

}
