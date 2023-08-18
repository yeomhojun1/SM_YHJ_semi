	package kh.yhjsemi.student.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiStudentDao {
	public List<SemiStudentVo> selectListStudent(SqlSession sesson){
		System.out.println("[selectListStudent 시작]");
		List<SemiStudentVo> result =sesson.selectList("semiStudentMapper1.selectListStudent");
		System.out.println("[selectListStudent]"+result);
		return result;
	}
	public List<SemiStudentVo> selectsearchStudent(SqlSession sesson,String searchword){
		System.out.println("[selectsearchStudent 시작]");
		searchword = "%"+searchword+"%";
		List<SemiStudentVo> result =sesson.selectList("semiStudentMapper1.selectsearchStudent",searchword);
		System.out.println("[selectsearchStudent]"+result);
		return result;
	}
	public List<SemiWeekVo> selectOneStudent(SqlSession sesson, String mid2) {
		System.out.println("[selectOneStudent]");
		 List<SemiWeekVo> result =sesson.selectList("semiStudentMapper1.selectOneStudent",mid2);
		System.out.println("[selectOneStudent]"+result);
		return result;
	}
	public int insertStudent(SqlSession sesson, SemiStudentVo vo) {
		System.out.println("[insertStudent 시작]");
		int result=sesson.insert("semiStudentMapper1.insertStudent",vo);
		System.out.println("[insertStudent]"+result);
		return result;
	}
	public int deleteStudent(SqlSession sesson, String mid2) {
		System.out.println("[deleteStudent 시작]");
		int result=sesson.delete("semiStudentMapper1.deleteStudent",mid2);
		System.out.println("[deleteStudent]"+result);
		return result;
	}
}
