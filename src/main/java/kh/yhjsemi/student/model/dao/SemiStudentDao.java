	package kh.yhjsemi.student.model.dao;

import java.sql.Connection;
import java.sql.Date;
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
		System.out.println("[selectListStudent 시작]");
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
				vo.setExamScore(rs.getString("EXAM_sCORE"));
				vo.setBirthday(rs.getString("BIRTHDAY"));
				vo.setEnterDate(rs.getString("ENter_date"));
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
		System.out.println("[selectListStudent]"+result);
		return result;
	}
	public List<SemiStudentVo> selectsearchStudent(Connection conn,String searchword){
		System.out.println("[selectsearchStudent 시작]");
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
				vo.setExamScore(rs.getString("EXAM_sCORE"));
				vo.setBirthday(rs.getString("BIRTHDAY"));
				vo.setEnterDate(rs.getString("ENter_date"));
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
		System.out.println("[selectsearchStudent]"+result);
		return result;
	}
	public List<SemiWeekVo> selectOneStudent(Connection conn, String mid2) {
		System.out.println("[selectOneStudent]");
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
		
		System.out.println("[selectOneStudent]"+result);
		
		return result;
	}
	public int insertStudent(Connection conn, SemiStudentVo vo) {
		System.out.println("[insertStudent 시작]");
		int result=0;
		String sql= "insert into aca_student (mid2,student_Name,exam_Score,birthday,enter_Date"
				+ ",important,mid,tele) values(?,?,?,to_date(?,'yy-mm-dd'),to_date(?,'yy-mm-dd'),?,?,?)";
		PreparedStatement pstmt= null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid2());
			pstmt.setString(2, vo.getStudentName());
			pstmt.setString(3, vo.getExamScore());
			pstmt.setString(4, vo.getBirthday());
			pstmt.setString(5, vo.getEnterDate());
			pstmt.setString(6, vo.getImportant());
			pstmt.setString(7, vo.getMid());
			pstmt.setString(8, vo.getTele());
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}System.out.println("[insertStudent]"+result);
		return result;
	}
	public int deleteStudent(Connection conn, String mid2) {
		System.out.println("[deleteStudent 시작]");
		int result= 0;
		String sql = "delete from aca_student where mid2 = ?  ";
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mid2);
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		System.out.println("[deleteStudent]"+result);
		return result;
	}
}
