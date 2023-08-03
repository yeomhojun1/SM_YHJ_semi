package kh.yhjsemi.teacher.service;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import kh.yhjsemi.common.jdbc.JdbcTemplate;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.teacher.model.dao.SemiTeacherDao;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiTeacherService {
	private SemiTeacherDao dao = new SemiTeacherDao();

	public List<SemiTeacherVo> selectListTeacher(){
		Connection conn = JdbcTemplate.getConnection();
		List<SemiTeacherVo> result = dao.selectListTeacher(conn);
		close(conn);
		return result;
	}
	public List<SemiTeacherVo> selectsearchTeacher(String searchword) {
		Connection conn = JdbcTemplate.getConnection();
		List<SemiTeacherVo> result = dao.selectsearchTeacher(conn,searchword);
		close(conn);
		return result;
	}
	public List<SemiStudentVo> selectOneTeacher(String mid2) {
		Connection conn = getConnection();
		List<SemiStudentVo> result = dao.selectOneTeacher(conn,mid2);
		close(conn);
		return result;
	}
}
