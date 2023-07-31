package kh.yhjsemi.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;

import kh.yhjsemi.student.model.vo.SemiStudentVo;

public class SemiStudentDao {
	public List<SemiStudentVo> selectListStudent(Connection conn){
		List<SemiStudentVo> result =null;
		String sql = "SELECT * FROM ACA_STUDENT";
		
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
}
