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
	public List<SemiMemberVo> selectListMember(Connection conn) {
		System.out.println("[selectListMember 시작]");
		List<SemiMemberVo> result = new ArrayList<SemiMemberVo>();

		String subquery = 
				 "select mid,  decode(mtype,'A','학원','S','학생','T','선생님') AS mtype, "
				 + "decode(mtype"
				 + ",'S', (select  student_name from ACA_STUDENT s where s.mid2=m.mid)"
				 + ", 'T', (select  teacher_name t from teacher t where t.mid=m.mid)"
				 + ", 'A',(select  aca_name from academy a where a.aca_no=m.mid )) mname "
				 + " from aca_member m"
				 + " order by mid" ;
				

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(subquery);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				SemiMemberVo vo = new SemiMemberVo(	);
						vo.setMid( rs.getString("mid"));
						vo.setMname( rs.getString("mname"));
						vo.setMtype( rs.getString("mtype"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[selectListMember]"+result);
		return result;
	}
	public SemiMemberVo selectOne(Connection conn, String  meid) {
		System.out.println("[Board Dao selectOne] bno:" + meid);
		SemiMemberVo result = null;
		// TODO
		System.out.println("[Board Dao selectOne] return:" + result);
		return result;
	}

	public SemiMemberVo login(Connection conn, SemiMemberVo vo ) {
		System.out.println("[login 멤버vo 시작]");
		String query = " select m.*,  decode(mtype,'S', (select  student_name from ACA_STUDENT where mid2=?),"
				+ " 'T', (select  teacher_name from teacher where mid=?),"
				+ " 'A',(select  aca_name from academy where aca_no=?)) mname "
				+ " from aca_member m "
				+ " where mid=? and mpwd=? ";

		PreparedStatement pstmt = null;
		SemiMemberVo result =null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getMid());
			pstmt.setString(4, vo.getMid());
			pstmt.setString(5, vo.getMpwd());
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result= new SemiMemberVo();
				result.setMid(rs.getString("mid"));
				result.setMtype(rs.getString("mtype"));
				result.setMname(rs.getString("mname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[login]"+result);
		return result;
	}
//	public String login(Connection conn, String meid ) {
//		System.out.println("[login 아이디만 보유 시작]");
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
//		System.out.println("[login 아이디랑 타입 시작]");
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
//	}
	public int insertMember(Connection conn, SemiMemberVo vo) {
		System.out.println("[insertMember]");
		int result= 0;
		System.out.println("[vo]="+vo);
		String sql= "insert into aca_member (mid,mpwd,mtype) values(?,?,?)";
		PreparedStatement pstmt= null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpwd());
			pstmt.setString(3, vo.getMtype());
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		System.out.println("[insertMember]"+result);
		return result;
	}
	public int deleteMember(Connection conn, String mid) {
		System.out.println("[deleteMember]");
		int result= 0;
		String sql = "delete from aca_member where mid = ?  ";
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		System.out.println("[deleteMember]"+result);
		return result;
	}
	}

