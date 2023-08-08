package kh.yhjsemi.student.service;

import java.sql.Connection;
import java.util.List;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.yhjsemi.common.jdbc.JdbcTemplate;
import kh.yhjsemi.student.model.dao.SemiStudentDao;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.teacher.model.dao.SemiTeacherDao;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiStudentService {
	private SemiStudentDao dao = new SemiStudentDao();

	public List<SemiStudentVo> selectListStudent() {
		Connection conn = JdbcTemplate.getConnection();
		List<SemiStudentVo> result = dao.selectListStudent(conn);
		close(conn);
		return result;
	}
	public List<SemiStudentVo> selectsearchStudent(String searchword) {
		Connection conn = JdbcTemplate.getConnection();
		List<SemiStudentVo> result = dao.selectsearchStudent(conn,searchword);
		close(conn);
		return result;
	}
	public List<SemiWeekVo> selectOneStudent( String mid2) {
		Connection conn = getConnection();
		List<SemiWeekVo> result = dao.selectOneStudent(conn,mid2);
		close(conn);
		return result;
	}
	public int insertStudent( SemiStudentVo vo) {
		int result =0;
		Connection conn = getConnection();
		result= dao.insertStudent(conn, vo);
		close(conn);
		return result;
	}
	public int deleteStudent( String mid2) {
		int result= 0;
		Connection conn = getConnection();
		result= dao.deleteStudent(conn, mid2);
		close(conn);
		return result;
	}
	
}
