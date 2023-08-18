package kh.yhjsemi.academy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.yhjsemi.academy.model.vo.SemiAcademyVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

public class SemiAcademyDao {
	public List<SemiAcademyVo> selectListAcademy(SqlSession sesson){
		List<SemiAcademyVo> result= sesson.selectList("semiAcademyMapper1.selectListAcademy");
		return result;
	}
	public List<SemiTeacherVo> selectOneAcademy(SqlSession sesson,String acano){
		List<SemiTeacherVo> result=sesson.selectList("semiAcademyMapper1.selectOneAcademy");
		return result;
	}
}
