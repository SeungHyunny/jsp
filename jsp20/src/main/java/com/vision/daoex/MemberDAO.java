package com.vision.daoex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "ai403";
	private String pwd = "java";
	
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> selectAll(Connection conn) {
		ArrayList<MemberDTO> dtoes = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "SELECT * FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("ID"));
				dto.setName(rs.getString("NAME"));
				dto.setPw(rs.getString("PW"));
				dto.setPhone(rs.getString("PHONE"));
				dtoes.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null && !rs.isClosed()) rs.close();
				if(pstmt != null && !pstmt.isClosed()) pstmt.close();
				if(conn != null && !conn.isClosed()) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtoes;
	}
}
