package kh.yhjsemi.board.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.jdbckh.common.jdbc.MyBatisTemplate;
import kh.yhjsemi.board.model.dao.SemiBoardDao;
import kh.yhjsemi.board.model.vo.SemiBoardVo;

public class SemiBoardService {
	private SemiBoardDao dao = new SemiBoardDao();
	public List<SemiBoardVo> selectListboard(){
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<SemiBoardVo> result = dao.selectListboard(session);
		session.close();
		return result;
	}
	public List<SemiBoardVo> selectsearchboard(String searchword){
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<SemiBoardVo> result = dao.selectsearchboard(session,searchword);
		session.close();
		return result;
	}
	public SemiBoardVo selectOneboard( int bno ) {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		SemiBoardVo result = dao.selectOneboard(session,bno);
		session.close();
		return result;
	}
	public int insertboard( SemiBoardVo vo) {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		int result = dao.insertboard(session,vo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	public int deleteboard( int bno) {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		int result = dao.deleteboard(session,bno);
		session.close();
		return result;
	}
}
