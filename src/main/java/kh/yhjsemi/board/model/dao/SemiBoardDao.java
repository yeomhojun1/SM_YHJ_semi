package kh.yhjsemi.board.model.dao;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.yhjsemi.board.model.vo.SemiBoardVo;


public class SemiBoardDao {
	
	public List<SemiBoardVo> selectListboard(SqlSession session){
		System.out.println("[selectListboard 시작]");
		List<SemiBoardVo> result =session.selectList("semiBoardMapper1.selectListboard");
		System.out.println("[selectListboard]"+result);
		return result;
	}
	public List<SemiBoardVo> selectsearchboard(SqlSession session,String searchword){
		System.out.println("[selectsearchboard 시작]");
		searchword = "%"+searchword+"%";
		List<SemiBoardVo> result = session.selectList("semiBoardMapper1.selectsearchboard",searchword);
		System.out.println("[selectsearchboard]"+result);
		return result;
	}
	public SemiBoardVo selectOneboard(SqlSession session, int bno ) {
		System.out.println("[selectOneboard 시작]");
		SemiBoardVo result =session.selectOne("semiBoardMapper1.selectOneboard",bno);
		System.out.println("[selectOneboard]"+result);
		return result;
	}
	public int insertboard(SqlSession session, SemiBoardVo vo) {
		System.out.println("[insertboard 시작]");
		int result= session.insert("semiBoardMapper1.insertboard",vo);
		System.out.println("[insertboard]"+result);
		return result;
	}
	public int deleteboard(SqlSession session, int bno) {
		System.out.println("[deleteboard 시작]");
		int result= session.delete("semiBoardMapper1.deleteboard",bno);
		System.out.println("[deleteboard]"+result);
		return result;
	}
}
