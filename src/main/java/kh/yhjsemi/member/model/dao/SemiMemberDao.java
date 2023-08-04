package kh.yhjsemi.member.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;
import kh.yhjsemi.member.model.vo.SemiMemberVo;

public class SemiMemberDao {
	public List<SemiMemberVo> selectList(Connection conn) {
		System.out.println("[Board Dao selectList]");
		List<SemiMemberVo> result = new ArrayList<SemiMemberVo>();

		String subquery = "select * from aca_member ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(subquery);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				SemiMemberVo dto = new SemiMemberVo(
						
						);
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	

	// 한 행 읽기 - PK로where조건
	public SemiMemberVo selectOne(Connection conn, String  mid) {
		System.out.println("[Board Dao selectOne] bno:" + mid);
		SemiMemberVo result = null;
		// TODO
		System.out.println("[Board Dao selectOne] return:" + result);
		return result;
	}

	// 한 행 삽입 - Member 자료형을 받아와야 함.
	public int insert(Connection conn, SemiMemberVo dto) {
		System.out.println("[Board Dao insert] dto:" + dto);
		int result = 0;
		String query = "";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao insert] return:" + result);
		return result;
	}
	


	public int login(Connection conn, SemiMemberVo vo ) {
		String query = "select count(*) cnt from aca_member where mid=? and mpwd=?";
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpwd());
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public String login(Connection conn, String mid ) {
		String result = null;
		String query = "select mpwd from aca_member where mid=? ";
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("mpwd");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
		
		
	}
	public SemiMemberVo login(Connection conn, String mid,String mtype ) {
		SemiMemberVo result = null;
		String query = "";
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			if(mtype.equals("t")) {
				query= "select mid, mpwd, mtype,(select teacher_name from teacher where mid=?) mname from aca_member where mid=? ";
			}else if(mtype.equals("s")) {
				query="select mid, mpwd, mtype,(select student_name from aca_student where mid2=?) mname from aca_member where mid=? ";
			}
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			pstmt.setString(2, mid);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result= new SemiMemberVo(
						rs.getString("mid"),
						rs.getString("mpwd"),
						rs.getString("mtype"),
						rs.getString("mname")
						
						
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
		
		
	}
}

