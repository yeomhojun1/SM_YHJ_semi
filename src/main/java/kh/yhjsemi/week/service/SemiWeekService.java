package kh.yhjsemi.week.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.jdbckh.common.jdbc.MyBatisTemplate;
import kh.yhjsemi.week.model.dao.SemiWeekDao;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiWeekService {
	private SemiWeekDao dao = new SemiWeekDao();
	public List<SemiWeekVo> selectListWeek(){
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<SemiWeekVo> result = dao.selectListWeek(session);
		session.close();
		return result;
	}
//	public List<SemiWeekVo> selectListWeek(String searchword){
//		SqlSession session = MyBatisTemplate.getSqlSession(true);
//		List<SemiWeekVo> result = dao.selectListWeek(session, searchword);
//		session.close();
//		return result;
//	}
//	public int getTotalCount( ) {
//		SqlSession session = MyBatisTemplate.getSqlSession(true);
//		int result = dao.getTotalCount(session);
//		session.close();
//		return result;
//	}
	public int insertWeek( SemiWeekVo vo) {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		int result = dao.insertWeek(session,vo);
		session.close();
		return result;
	}
}
