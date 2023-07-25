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
			System.out.println(rs);
			result = new ArrayList<SemiStudentVo>();
			while(rs.next()==true) {
				SemiStudentVo vo = new SemiStudentVo();
				vo.setStudentNo(rs.getString("student_no"));
				vo.setStudentName(rs.getString("student_name"));
				vo.setAge(rs.getInt("AGE"));
				vo.setParentNumber(rs.getString("PHONE"));
				result.add(vo);
				
				
				
			}
			
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println(result);
		return result;
	}
}
