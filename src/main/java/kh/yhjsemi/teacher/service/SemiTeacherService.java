package kh.yhjsemi.teacher.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.jdbckh.common.jdbc.MyBatisTemplate;
import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.teacher.model.dao.SemiTeacherDao;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;

public class SemiTeacherService {
	private SemiTeacherDao dao = new SemiTeacherDao();

	public List<SemiTeacherVo> selectListTeacher(){
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<SemiTeacherVo> result = dao.selectListTeacher(session);
		return result;
	}
	public List<SemiTeacherVo> selectsearchTeacher(String searchword) {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<SemiTeacherVo> result = dao.selectsearchTeacher(session,searchword);
		return result;
	}
	public List<SemiStudentVo> selectOneTeacher(String mid2) {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<SemiStudentVo> result = dao.selectOneTeacher(session,mid2);
		return result;
	}
	public int insertTeacher(SemiTeacherVo vo) {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		int result = dao.insertTeacher(session,vo);
		return result;
	}
}
