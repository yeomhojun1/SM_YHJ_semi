package kh.yhjsemi.member.service;


import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.test.jdbckh.common.jdbc.MyBatisTemplate;
import kh.yhjsemi.member.model.dao.SemiMemberDao;
import kh.yhjsemi.member.model.vo.SemiMemberVo;


public class SemiMemberService {
	private SemiMemberDao dao= new SemiMemberDao();
	public List<SemiMemberVo> selectListMember() {
		List<SemiMemberVo> result = null;
		Connection conn = getConnection();
		result = dao.selectListMember(conn);
		close(conn);
		return result;
	}

	// 한 행 읽기 - PK로where조건
	public SemiMemberVo selectOne(String meid) {
		SemiMemberVo result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, meid);
		close(conn);
		return result;
	}

//	public String login(String meid) {
//		String result = null;
//		Connection conn = getConnection();
//		result = dao.login(conn, meid);
//		close(conn);
//		return result;
//	}
	public SemiMemberVo login(SemiMemberVo vo) {
		SemiMemberVo result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.login(session, vo);
		session.close();
		return result;
	}
	public int insertMember(SemiMemberVo vo) {
		int result =0;
		Connection conn = getConnection();
		result= dao.insertMember(conn, vo);
		close(conn);
		return result;
	}
	public int deleteMember( String mid) {
		int result= 0;
		Connection conn = getConnection();
		result= dao.deleteMember(conn, mid);
		close(conn);
		return result;
	}
}
