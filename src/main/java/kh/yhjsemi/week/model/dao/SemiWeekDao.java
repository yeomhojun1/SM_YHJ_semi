package kh.yhjsemi.week.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;
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

}	
