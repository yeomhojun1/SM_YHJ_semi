package kh.yhjsemi.student.service;

import java.sql.Connection;
import java.util.List;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.yhjsemi.common.jdbc.JdbcTemplate;
import kh.yhjsemi.student.model.dao.SemiStudentDao;
import kh.yhjsemi.student.model.vo.SemiStudentVo;

public class SemiStudentService {
	private SemiStudentDao dao = new SemiStudentDao();

	public List<SemiStudentVo> selectListStudent() {
		Connection conn = getConnection();
		List<SemiStudentVo> result = dao.selectListStudent(conn);
		close(conn);
		return result;
	}
	
}
