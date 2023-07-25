package kh.yhjsemi.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.yhjsemi.student.model.vo.SemiStudentVo;

public class SemiStudentDao {
	public List<SemiStudentVo> selectListStudent(){
		List<SemiStudentVo> result =null;
		String sql = "SELECT * FROM SMY";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<SemiStudentVo>();
			while(rs.next()) {
				SemiStudentVo vo = new SemiStudentVo();
				vo.setStudentName(rs.getString("student_name"));
				vo.setGrade(rs.getString("학년"));
				vo.setStudentNo(rs.getString("student_no"));
				vo.setParentNumber(rs.getString("부모전화번호"));
				result.add(vo);
				
				
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}
}
