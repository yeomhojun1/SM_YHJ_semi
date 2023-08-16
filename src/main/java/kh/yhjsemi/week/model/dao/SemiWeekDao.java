package kh.yhjsemi.week.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiWeekDao {
	public List<SemiWeekVo> selectListWeek(Connection conn){
		List<SemiWeekVo> result= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "select w.* ,(select student_name from aca_student s where s.mid2=w.st_id) student_name from st_week w";
		try {
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = new ArrayList<SemiWeekVo>();
			}do {
				SemiWeekVo vo = new SemiWeekVo(
						rs.getInt("monthNo"),
						rs.getString("tc_id"),
						rs.getString("st_id"),
						rs.getString("expect"),
						rs.getString("study"),
						rs.getString("st_Comment"),
						rs.getString("acheive"),
						rs.getInt("week_Score"),
						rs.getString("student_Name")
						);
				result.add(vo);
				}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public List<SemiWeekVo> selectListWeek(Connection conn,String searchword){
		List<SemiWeekVo> result= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "select (select student_name from aca_student a where mid2=?) student_name,s.* from st_week s where expect like ? or study like ?";
		try {
			searchword = "%"+searchword+"%";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, searchword);
			pstmt.setString(2, searchword);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = new ArrayList<SemiWeekVo>();
			}do {
				SemiWeekVo vo = new SemiWeekVo(
						rs.getInt("monthNo"),
						rs.getString("tc_id"),
						rs.getString("st_id"),
						rs.getString("expect"),
						rs.getString("study"),
						rs.getString("st_Comment"),
						rs.getString("acheive"),
						rs.getInt("week_Score"),
						rs.getString("student_Name")
						);
				result.add(vo);
				}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int getTotalCount(Connection conn) {
		int result = 0;
		String sql = "select count(*)+1 cnt from st_week";
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
//	private int monthNo;
//	private String tcid;
//	private String stid;
//	private String expect;
//	private String study;
//	private String stComment;
//	private String acheive;
//	private int weekScore;
//	private String studentName;
	public int insertWeek(Connection conn, SemiWeekVo vo) {
		System.out.println("[insertWeek 시작]");
		int result=0;
		String sql= "insert into st_week (monthNo,tcid,stid,expect,study"
				+ ",stComment,acheive,weekScore,studentName) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt= null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMonthNo());
			pstmt.setString(2, vo.getTcid());
			pstmt.setString(3, vo.getStid());
			pstmt.setString(4, vo.getExpect());
			pstmt.setString(5, vo.getStudy());
			pstmt.setString(6, vo.getStComment());
			pstmt.setString(7, vo.getAcheive());
			pstmt.setInt(8, vo.getWeekScore());
			pstmt.setString(9, vo.getStudentName());
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}System.out.println("[insertWeek]"+result);
		return result;
	}
}	
