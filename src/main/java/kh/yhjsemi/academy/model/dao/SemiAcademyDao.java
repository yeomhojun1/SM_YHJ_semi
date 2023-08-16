package kh.yhjsemi.academy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.yhjsemi.academy.model.vo.SemiAcademyVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

public class SemiAcademyDao {
	public List<SemiAcademyVo> selectListAcademy(Connection conn){
		List<SemiAcademyVo> result= new ArrayList<SemiAcademyVo>();
		String sql = "select * from academy";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					SemiAcademyVo vo = new SemiAcademyVo(
					rs.getString("aca_no"),
					rs.getString("aca_address"),
					rs.getString("aca_name"),
					rs.getString("aca_phone")
					);
					result.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
		return result;
	}
	public List<SemiTeacherVo> selectOneAcademy(Connection conn,String acano){
		List<SemiTeacherVo> result= new ArrayList<SemiTeacherVo>();
		getConnection();
		String sql = "select mid, teacher_name, entrance_date,aca_no from teacher where aca_no=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acano);
			 rs= pstmt.executeQuery();
			while(rs.next()) {
				SemiTeacherVo vo = new SemiTeacherVo(
						rs.getString("mid"),
						rs.getString("teacher_name"),
						rs.getString("entrance_date"),
						rs.getString("aca_no")
						);
				result.add(vo);
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
