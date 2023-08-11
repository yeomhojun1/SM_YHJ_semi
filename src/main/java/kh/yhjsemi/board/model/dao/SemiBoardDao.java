package kh.yhjsemi.board.model.dao;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.yhjsemi.board.model.vo.SemiBoardVo;


public class SemiBoardDao {
	
	public List<SemiBoardVo> selectListboard(Connection conn){
		System.out.println("[selectListboard 시작]");
		List<SemiBoardVo> result =null;
		String sql = "SELECT bno,bwriter,btitle FROM bboard order by bno desc";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiBoardVo>();
				do {
				SemiBoardVo vo = new SemiBoardVo();
					vo.setBno( rs.getInt("bno"));
					vo.setBwriter(rs.getString("bwriter"));
					vo.setBtitle(rs.getString("btitle"));
				result.add(vo);
			}while(rs.next() == true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[selectListboard]"+result);
		return result;
	}
	public List<SemiBoardVo> selectsearchboard(Connection conn,String searchword){
		System.out.println("[selectsearchboard 시작]");
		List<SemiBoardVo> result =null;
		String sql = "SELECT bno,bwriter,btitle FROM bboard where btitle like ? or bwriter like ? ";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			searchword = "%"+searchword+"%";  
			pstmt.setString(1, searchword);
			pstmt.setString(2, searchword);
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiBoardVo>();
				do {
				SemiBoardVo vo = new SemiBoardVo();
				vo.setBno( rs.getInt("bno"));
				vo.setBwriter(rs.getString("bwriter"));
				vo.setBtitle(rs.getString("btitle"));
				result.add(vo);
			}while(rs.next() == true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[selectsearchboard]"+result);
		return result;
	}
	public SemiBoardVo selectOneboard(Connection conn, int bno ) {
		System.out.println("[selectOneboard 시작]");
		SemiBoardVo result =null;
		String sql = "select bno,bwriter,btitle,bcontent FROM bboard where bno=?";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result =new SemiBoardVo();
				result.setBno( rs.getInt("bno"));
				result.setBwriter(rs.getString("bwriter"));
				result.setBtitle(rs.getString("btitle"));
				result.setBcontent(rs.getString("bcontent"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[selectOneboard]"+result);
		return result;
	}
	public int insertboard(Connection conn, SemiBoardVo vo) {
		System.out.println("[insertboard 시작]");
		int result=0;
		String sql= "INSERT INTO BBOARD (BWRITER,BWRITER_NO,BTITLE,BCONTENT) VALUES ( ?, ?, ?,?)";
		PreparedStatement pstmt= null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBwriter());
			pstmt.setString(2, vo.getBwriterNo());
			pstmt.setString(3, vo.getBtitle());
			pstmt.setString(4, vo.getBcontent());
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		System.out.println("[insertboard]"+result);
		return result;
	}
	public int deleteboard(Connection conn, int bno) {
		System.out.println("[deleteboard 시작]");
		int result= 0;
		String sql = "delete from bboard where bno = ?  ";
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		System.out.println("[deleteboard]"+result);
		return result;
	}
}
