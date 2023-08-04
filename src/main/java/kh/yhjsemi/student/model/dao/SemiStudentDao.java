	package kh.yhjsemi.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiStudentDao {
	public List<SemiStudentVo> selectListStudent(Connection conn){
		List<SemiStudentVo> result =null;
		String sql = "SELECT * FROM ACA_STUDENT";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiStudentVo>();
				do {
				SemiStudentVo vo = new SemiStudentVo();
				vo.setMid2(rs.getString("MID2"));
				vo.setStudentName(rs.getString("student_NAME"));
				vo.setExamScore(rs.getInt("EXAM_sCORE"));
				vo.setBirthday(rs.getDate("BIRTHDAY"));
				vo.setEnterDate(rs.getDate("ENter_date"));
				vo.setImportant(rs.getString("important"));
				vo.setMid(rs.getString("mid"));
				vo.setTele(rs.getString("tele"));
				result.add(vo);
			}while(rs.next() == true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public List<SemiStudentVo> selectsearchStudent(Connection conn,String searchword){
		List<SemiStudentVo> result =null;
		String sql = "SELECT * FROM ACA_STUDENT where student_name like ? ";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			searchword = "%"+searchword+"%";  
			pstmt.setString(1, searchword);
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiStudentVo>();
				do {
				SemiStudentVo vo = new SemiStudentVo();
				vo.setMid2(rs.getString("MID2"));
				vo.setStudentName(rs.getString("student_NAME"));
				vo.setExamScore(rs.getInt("EXAM_sCORE"));
				vo.setBirthday(rs.getDate("BIRTHDAY"));
				vo.setEnterDate(rs.getDate("ENter_date"));
				vo.setImportant(rs.getString("important"));
				vo.setMid(rs.getString("mid"));
				vo.setTele(rs.getString("tele"));
				result.add(vo);
			}while(rs.next() == true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public List<SemiWeekVo> selectOneStudent(Connection conn, String mid2) {
		 List<SemiWeekVo> result =null;
		String sql = "select (select student_name from aca_student a where mid2=?) student_name, monthNo,Tc_id,St_id,Expect,Study,St_Comment,Acheive,Week_Score"
				+ " from st_week s where st_id = ?";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid2);
			pstmt.setString(2, mid2);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result =new ArrayList<SemiWeekVo>();
			do {
					SemiWeekVo vo = new SemiWeekVo();
					vo.setMonthNo(rs.getInt("monthNo"));
					vo.setTcid(rs.getString("Tc_id"));
					vo.setStid(rs.getString("St_id"));
					vo.setExpect(rs.getString("Expect"));
					vo.setStudy(rs.getString("Study"));
					vo.setStComment(rs.getString("St_Comment"));
					vo.setAcheive( rs.getString("Acheive"));
					vo.setWeekScore(rs.getInt("Week_Score"));
					vo.setStudentName(rs.getString("Student_Name"));
					result.add(vo);
			}while(rs.next()==true);
			}
			}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("dao실행됨");
		
		return result;
	}
	
}
