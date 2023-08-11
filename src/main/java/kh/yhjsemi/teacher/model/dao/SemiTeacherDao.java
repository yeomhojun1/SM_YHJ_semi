package kh.yhjsemi.teacher.model.dao;

import static kh.yhjsemi.common.jdbc.JdbcTemplate.close;
import static kh.yhjsemi.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.yhjsemi.student.model.vo.SemiStudentVo;
import kh.yhjsemi.teacher.model.vo.SemiTeacherVo;
import kh.yhjsemi.week.model.vo.SemiWeekVo;


public class SemiTeacherDao {
	public List<SemiTeacherVo> selectListTeacher(Connection conn){
		System.out.println("[selectListTeacher 시작]");
		List<SemiTeacherVo> result =null;
		String sql = "SELECT * FROM teacher";
		
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiTeacherVo>();
				do {
				SemiTeacherVo vo = new SemiTeacherVo();
				vo.setMid(rs.getString("MID"));
				vo.setTeacherName(rs.getString("teacher_NAME"));
				vo.setEntranceDate(rs.getDate("entrance_date"));
				vo.setAcaNo(rs.getString("aca_no"));
				result.add(vo);
			}while(rs.next() == true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}System.out.println("[selectListTeacher"+result);
		return result;
	}
	public List<SemiTeacherVo> selectsearchTeacher(Connection conn,String searchword){
		System.out.println("[selectsearchTeacher 시작]");
		List<SemiTeacherVo> result =null;
		String sql = "SELECT * FROM teacher where teacher_name like ? ";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			searchword = "%"+searchword+"%";  
			rs = pstmt.executeQuery();
		
			if(rs.next() ) {
				result = new ArrayList<SemiTeacherVo>();
				do {
					SemiTeacherVo vo = new SemiTeacherVo();
				vo.setMid(rs.getString("MID"));
				vo.setTeacherName(rs.getString("teacher_NAME"));
				vo.setEntranceDate(rs.getDate("entrance_date"));
				vo.setAcaNo(rs.getString("aca_no"));
			}while(rs.next() == true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[selectsearchTeacher"+result);
		return result;
	}
	public List<SemiStudentVo> selectOneTeacher(Connection conn, String mid) {
		System.out.println("[selectOneTeacher 시작]");
		 List<SemiStudentVo> result =null;
		String sql = "select mid2, student_name, exam_score,birthday,enter_date,important,mid,tele from aca_student where mid= ? ";
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result =new ArrayList<SemiStudentVo>();
			do {
				SemiStudentVo vo = new SemiStudentVo();
				vo.setMid2(rs.getString("MID2"));
				vo.setStudentName(rs.getString("student_NAME"));
				vo.setExamScore(rs.getString("EXAM_sCORE"));
				vo.setBirthday(rs.getString("BIRTHDAY"));
				vo.setEnterDate(rs.getString("ENter_date"));
				vo.setImportant(rs.getString("important"));
				vo.setMid(rs.getString("mid"));
				vo.setTele(rs.getString("tele"));
					result.add(vo);
			}while(rs.next()==true);
			}
			}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[selectOneTeacher"+result);
		return result;
	}
}
