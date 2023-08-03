package kh.yhjsemi.member.service;


import java.sql.Connection;
import java.util.List;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.yhjsemi.member.model.dao.SemiMemberDao;
import kh.yhjsemi.member.model.vo.SemiMemberVo;


public class SemiMemberService {
	private SemiMemberDao dao= new SemiMemberDao();
	public List<SemiMemberVo> selectList() {
		List<SemiMemberVo> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}

	// 한 행 읽기 - PK로where조건
	public SemiMemberVo selectOne(String mid) {
		SemiMemberVo result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, mid);
		close(conn);
		return result;
	}

	public String login(String mid) {
		String result = null;
		Connection conn = getConnection();
		result = dao.login(conn, mid);
		close(conn);
		return result;
	}
}
