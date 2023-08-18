package kh.yhjsemi.academy.service;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.jdbckh.common.jdbc.MyBatisTemplate;
import kh.yhjsemi.academy.model.dao.SemiAcademyDao;
import kh.yhjsemi.academy.model.vo.SemiAcademyVo;
import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;

public class SemiAcademyService {
	SemiAcademyDao dao = new SemiAcademyDao();

	public List<SemiAcademyVo> selectListAcademy() {
		List<SemiAcademyVo> result = null;

		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectListAcademy(session);
		session.close();
		return result;
	}
	public List<SemiTeacherVo> selectOneAcademy(String acano) {
		List<SemiTeacherVo> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectOneAcademy(session, acano);
		session.close();
		return result;
	}
}
