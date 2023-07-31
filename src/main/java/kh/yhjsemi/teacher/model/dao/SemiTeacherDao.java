package kh.yhjsemi.teacher.model.dao;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;


public class SemiTeacherDao {
	public List<SemiTeacherVo> selectListTeacher(Connection conn){
		List<SemiTeacherVo> result =null;
		String sql = "SELECT * FROM teacher";
		
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiTeacherVo>();
				do {
				SemiTeacherVo vo = new SemiTeacherVo();
				vo.setMid(rs.getString("MID"));
				vo.setTeacherName(rs.getString("teacher_NAME"));
				vo.setEntranceDate(rs.getDate("entrance_date"));
				vo.setAcaNo(rs.getString("aca_no"));
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
}
