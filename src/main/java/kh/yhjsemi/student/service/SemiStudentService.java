package kh.yhjsemi.student.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import kh.test.jdbckh.common.jdbc.MyBatisTemplate;
import kh.yhjsemi.student.model.dao.SemiStudentDao;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiStudentService {
	private SemiStudentDao dao = new SemiStudentDao();

	public List<SemiStudentVo> selectListStudent() {
		List<SemiStudentVo> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectListStudent(session);
		session.close();
		return result;
	}
	public List<SemiStudentVo> selectsearchStudent(String searchword) {
		List<SemiStudentVo> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectsearchStudent(session, searchword);
		session.close();
		return result;
	}
	public List<SemiWeekVo> selectOneStudent( String mid2) {
		List<SemiWeekVo> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectOneStudent(session, mid2);
		session.close();
		return result;
	}
	public int insertStudent( SemiStudentVo vo) {
		int result =0;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result= dao.insertStudent(session, vo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	public int deleteStudent( String mid2) {
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.deleteStudent(session, mid2);
		session.close();
		return result;
	}
}
