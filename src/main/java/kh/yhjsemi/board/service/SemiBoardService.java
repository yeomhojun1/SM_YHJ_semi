package kh.yhjsemi.board.service;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.util.List;

import kh.yhjsemi.board.model.dao.SemiBoardDao;
import kh.yhjsemi.board.model.vo.SemiBoardVo;
import kh.yhjsemi.common.jdbc.JdbcTemplate;

public class SemiBoardService {
	private SemiBoardDao dao = new SemiBoardDao();
	public List<SemiBoardVo> selectListboard(){
		Connection conn = JdbcTemplate.getConnection();
		List<SemiBoardVo> result = dao.selectListboard(conn);
		close(conn);
		return result;
	}
	public List<SemiBoardVo> selectsearchboard(String searchword){
		Connection conn = JdbcTemplate.getConnection();
		List<SemiBoardVo> result = dao.selectsearchboard(conn,searchword);
		close(conn);
		return result;
	}
	public SemiBoardVo selectOneboard( int bno ) {
		Connection conn = JdbcTemplate.getConnection();
		SemiBoardVo result = dao.selectOneboard(conn,bno);
		close(conn);
		return result;
	}
	public int insertboard( SemiBoardVo vo) {
		Connection conn = JdbcTemplate.getConnection();
		int result = dao.insertboard(conn,vo);
		close(conn);
		return result;
	}
	public int deleteboard( int bno) {
		Connection conn = JdbcTemplate.getConnection();
		int result = dao.deleteboard(conn,bno);
		close(conn);
		return result;
	}
}
