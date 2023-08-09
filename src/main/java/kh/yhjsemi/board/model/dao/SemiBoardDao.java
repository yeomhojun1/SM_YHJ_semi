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
		List<SemiBoardVo> result =null;
		String sql = "SELECT bno,bwriter,btitle FROM bboard";
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
					vo.setBWRITER(rs.getString("bwriter"));
					vo.setBTITLE(rs.getString("btitle"));
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
	public List<SemiBoardVo> selectsearchboard(Connection conn,String searchword){
		List<SemiBoardVo> result =null;
		String sql = "SELECT bno,bwriter,btitle FROM board where btitle like ? ";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			searchword = "%"+searchword+"%";  
			pstmt.setString(1, searchword);
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiBoardVo>();
				do {
				SemiBoardVo vo = new SemiBoardVo();
				vo.setBno( rs.getInt("bno"));
				vo.setBWRITER(rs.getString("bwriter"));
				vo.setBTITLE(rs.getString("btitle"));
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
	public SemiBoardVo selectOneboard(Connection conn, int bno ) {
		SemiBoardVo result =null;
		String sql = "select bno,bwriter,btitle,bcontent FROM board where bno=?";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result =new SemiBoardVo();
				SemiBoardVo vo = new SemiBoardVo();
				vo.setBno( rs.getInt("bno"));
				vo.setBWRITER(rs.getString("bwriter"));
				vo.setBTITLE(rs.getString("btitle"));
				vo.setBCONTENT(rs.getString("bcontent"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insertboard(Connection conn, SemiBoardVo vo) {
		int result=0;
		String sql= "INSERT INTO BBOARD (BNO,BWRITER,BWRITER_NO,BTITLE,BCONTENT) VALUES (?, ?, ?, ?,?);";
		PreparedStatement pstmt= null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBno());
			pstmt.setString(2, vo.getBWRITER());
			pstmt.setString(3, vo.getBWRITER_NO());
			pstmt.setString(4, vo.getBTITLE());
			pstmt.setString(5, vo.getBCONTENT());
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	public int deleteboard(Connection conn, int bno) {
		int result= 0;
		String sql = "delete from board where bno = ?  ";
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
		System.out.println(result);
		return result;
	}
}
