package kh.yhjsemi.teacher.service;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.util.List;

import kh.yhjsemi.common.jdbc.JdbcTemplate;
import kh.yhjsemi.teacher.model.dao.SemiTeacherDao;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;

public class SemiTeacherService {
	private SemiTeacherDao dao = new SemiTeacherDao();

	public List<SemiTeacherVo> selectListTeacher() {
		Connection conn = JdbcTemplate.getConnection();
		List<SemiTeacherVo> result = dao.selectListTeacher(conn);
		close(conn);
		return result;
	}
}
