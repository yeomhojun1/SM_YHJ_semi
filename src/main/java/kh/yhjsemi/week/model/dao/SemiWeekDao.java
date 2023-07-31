package kh.yhjsemi.week.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.yhjsemi.week.model.vo.SemiWeekVo;

public class SemiWeekDao {
	public List<SemiWeekVo> selectListWeek(Connection conn){
		List<SemiWeekVo> result= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "select * from st_week";
		pstmt= conn.prepareStatement(sql);
		rs= pstmt.executeQuery();
		if(rs.next()) {
			result = new ArrayList<SemiWeekVo>;
		}
		
		
		
		
		return result;
	}
}	
