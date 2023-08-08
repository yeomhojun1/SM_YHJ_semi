package kh.yhjsemi.academy.service;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import kh.yhjsemi.academy.model.dao.SemiAcademyDao;
import kh.yhjsemi.academy.model.vo.SemiAcademyVo;
import kh.yhjsemi.member.model.vo.SemiMemberVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;

public class SemiAcademyService {
	SemiAcademyDao dao = new SemiAcademyDao();
	public List<SemiAcademyVo> selectListAcademy(){
		List<SemiAcademyVo> result = null;
		Connection conn = getConnection();
		result = dao.selectListAcademy(conn);
		close(conn);
		return result;
	}
	public List<SemiTeacherVo> selectOneAcademy(String acano){
		List<SemiTeacherVo> result = null;
		Connection conn = getConnection();
		result = dao.selectOneAcademy(conn,acano);
		close(conn);
		return result;
	}
}
