package kh.yhjsemi.member.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.*;
import kh.yhjsemi.member.model.vo.SemiMemberVo;

public class SemiMemberDao {
	public List<SemiMemberVo> selectListMember(SqlSession session) {
		System.out.println("[selectListMember 시작]");
		List<SemiMemberVo> result = session.selectList("SemiMemberRM1.selectListMember");
		System.out.println("[selectListMember]"+result);
		return result;
	}
	
	public SemiMemberVo login(SqlSession session, SemiMemberVo vo ) {
		System.out.println("[login 시작]");
		SemiMemberVo result = session.selectOne("SemiMemberRM1.login",vo);
		System.out.println("[login]"+result);
		return result;
	}
//	public String login(Connection conn, String meid ) {
//		System.out.println("[login 시작]");
//		String result = null;
//		String query = "select mpwd from aca_member where mid=? ";
//		PreparedStatement pstmt = null;
//		ResultSet rs= null;
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, meid);
//			rs= pstmt.executeQuery();
//			if(rs.next()) {
//				result = rs.getString("mpwd");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		System.out.println("[login]"+result);
//		return result;
//	}
//	public SemiMemberVo login(Connection conn, String meid,String mtype ) {
//		System.out.println("[login 시작]");
//		SemiMemberVo result = null;
//		String query = "";
//		PreparedStatement pstmt = null;
//		ResultSet rs= null;
//		System.out.println(mtype);
//		try {
//			if(mtype.equals("t")) {
//				query= "select mid, mpwd, mtype,(select teacher_name from teacher where mid=?) mname from aca_member where mid=? ";
//			}else if(mtype.equals("s")) {
//				query="select mid, mpwd, mtype,(select student_name from aca_student where mid2=?) mname from aca_member where mid=? ";
//			}
//			else if(mtype.equals("a")) {
//				query="select mid, mpwd, mtype,(select aca_name from academy where aca_no=?) mname from aca_member where mid=? ";
//			}
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, meid);
//			pstmt.setString(2, meid);
//			rs= pstmt.executeQuery();
//			
//			if(rs.next()) {
//				result= new SemiMemberVo(
//						rs.getString("mid"),
//						rs.getString("mpwd"),
//						rs.getString("mtype"),
//						rs.getString("mname")
//						);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		System.out.println("[login]"+result);
//		return result;
	public int insertMember(SqlSession session, SemiMemberVo vo) {
		System.out.println("[insertMember]");
		int result= session.insert("SemiMemberRM1.insertMember",vo);
		System.out.println("[insertMember]"+result);
		return result;
	}
	public int deleteMember(SqlSession session, String mid) {
		System.out.println("[deleteMember]");
		int result= session.insert("SemiMemberRM1.deleteMember",mid);
		
		System.out.println("[deleteMember]"+result);
		return result;
	}
	}

