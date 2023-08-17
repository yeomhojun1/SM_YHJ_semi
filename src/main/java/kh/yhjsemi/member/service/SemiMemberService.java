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
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectListMember(session);
		session.close();
		return result;
	}

	// 한 행 읽기 - PK로where조건
	


	public SemiMemberVo login(SemiMemberVo vo) {
		SemiMemberVo result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.login(session, vo);
		session.close();
		return result;
	}
	public int insertMember(SemiMemberVo vo) {
		int result =0;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result= dao.insertMember(session, vo);
		session.close();
		return result;
	}
	public int deleteMember( String mid) {
		int result= 0;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result= dao.deleteMember(session, mid);
		session.close();
		return result;
	}
}
