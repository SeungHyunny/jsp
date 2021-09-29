package com.vision.invalid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// 이 클래스 사용목적 
// 1. 폼 자료를 디비에 입력 
// 2. 등록 가능한 ID인지 점검 
// 3. 사용자 체크(이 사이트 사용권한이 있는 사용자인지 비밀번호와 아이디 체크) 
// 4. ID로 한 사람 정보 얻기
// 5. 입력된 정보의 수정 


public class MemberDAO {
	// 사용할 상수 정의 
	public final static int MEMBER_NONEXISTENT = 0;
	public final static int MEMBER_EXISTENT = 1;
	
	public final static int MEMBER_JOIN_FAIL = 0;
	public final static int MEMBER_JOIN_SUCCESS = 1;
	
	public final static int MEMBER_LOGIN_IS_NOT = -1;
	public final static int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public final static int MEMBER_LOGIN_SUCCESS = 1;
	
	public final static int MEMBER_NOT_UPDATE = 0;
	public final static int MEMBER_UPDATE_SUCCESS = 1;
	
	
	// 싱글톤
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	// CRUD 관련 메소드 
	
	public int insertMember(MemberDTO dto) {
		int res  = 0;
		Connection conn = DBCPFactory.getInstance();
		String sql = "INSERT INTO MEMBER(ID,NAME,PW,PHONE) VALUES(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getPhone());
			int r = pstmt.executeUpdate();
			if(r>=1) {
				res = MemberDAO.MEMBER_JOIN_SUCCESS;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null && !pstmt.isClosed()) pstmt.close();
				if(conn !=null && !conn.isClosed()) conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		} 
		return res;
	}
	// 사용할 수 있는 ID인지 체크 
	public int confirmId(String id) {
		int res = 0; 
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = MemberDAO.MEMBER_EXISTENT;
			}else {
				res = MemberDAO.MEMBER_NONEXISTENT;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	// 사용자 체크 - 로그인시에 활용 
	public int userCheck(String id,String pw) {
		int res = 0; 
		String dbPw; 
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT PW FROM MEMBER WHERE ID=?";
		try {
			conn = DBCPFactory.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbPw = rs.getString("PW");
				if(dbPw.equals(pw)) {
					res = MemberDAO.MEMBER_LOGIN_SUCCESS;
				}else {
					res = MemberDAO.MEMBER_LOGIN_PW_NO_GOOD;
				}
			}else {
				res = MemberDAO.MEMBER_LOGIN_IS_NOT;
			}

		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} 
		return res;
	}
	// ID로 한 사람 정보 얻기
	public MemberDTO getMember(String id) {
		MemberDTO dto = null; 
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("ID"));
				dto.setName(rs.getString("NAME"));
				dto.setPw(rs.getString("PW"));
				dto.setPhone(rs.getString("PHONE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		return dto;
	}
	// 정보 수정 
	public int updateMember(MemberDTO dto) {
		int res = 0;
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE MEMBER SET NAME=?, PW=?,PHONE=? WHERE ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1,dto.getName());
			pstmt.setString(2,dto.getPw());
			pstmt.setString(3,dto.getPhone());
			pstmt.setString(4,dto.getId());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}	
	
	public ArrayList<MemberDTO> selectAll(Connection conn){
		ArrayList<MemberDTO> dtoes = new ArrayList<>();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
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
		} finally {
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
