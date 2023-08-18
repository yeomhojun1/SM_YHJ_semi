package kh.yhjsemi.teacher.model.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;


public class SemiTeacherDao {
	public List<SemiTeacherVo> selectListTeacher(SqlSession sesson){
		System.out.println("[selectListTeacher 시작]");
		List<SemiTeacherVo> result =sesson.selectList("semiTeacherMapper1.selectListTeacher");
		System.out.println("[selectListTeacher"+result);
		return result;
	}
	public List<SemiTeacherVo> selectsearchTeacher(SqlSession sesson,String searchword){
		System.out.println("[selectsearchTeacher 시작]");
		searchword="%"+searchword+"%";
		List<SemiTeacherVo> result =sesson.selectList("semiTeacherMapper1.selectsearchTeacher",searchword);
		System.out.println("[selectsearchTeacher"+result);
		return result;
	}
	public List<SemiStudentVo> selectOneTeacher(SqlSession sesson, String mid) {
		System.out.println("[selectOneTeacher 시작]");
		 List<SemiStudentVo> result =sesson.selectList("semiTeacherMapper1.selectOneTeacher",mid);
		System.out.println("[selectOneTeacher"+result);
		return result;
	}
	public int insertTeacher(SqlSession sesson, SemiTeacherVo vo) {
		System.out.println("[insertTeacher 시작]");
		int result=sesson.insert("semiTeacherMapper1.insertTeacher",vo);
		System.out.println("[insertTeacher]"+result);
		return result;
	}
}
