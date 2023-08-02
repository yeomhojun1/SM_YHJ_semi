package kh.yhjsemi.week.service;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.util.List;

import kh.yhjsemi.common.jdbc.JdbcTemplate;
import kh.yhjsemi.week.model.dao.SemiWeekDao;
import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiWeekService {
	private SemiWeekDao dao = new SemiWeekDao();
	public List<SemiWeekVo> selectListWeek(){
		Connection conn = JdbcTemplate.getConnection();
		List<SemiWeekVo> result = dao.selectListWeek(conn);
		close(conn);
		return result;
	}
	public List<SemiWeekVo> selectListWeek(String searchword){
		Connection conn = JdbcTemplate.getConnection();
		List<SemiWeekVo> result = dao.selectListWeek(conn, searchword);
		close(conn);
		return result;
	}
	public int getTotalCount( ) {
		Connection conn = JdbcTemplate.getConnection();
		int result = dao.getTotalCount(conn);
		close(conn);
		return result;
	}
	public List<SemiWeekVo> selectListWeek(int currentpage, int pagesize,int totalpage){
		Connection conn = JdbcTemplate.getConnection();
		List<SemiWeekVo> result = dao.selectListWeek(conn, currentpage,pagesize,totalpage);
		close(conn);
		return result;
	}
		
}
