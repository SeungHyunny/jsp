package com.vision.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.vision.common.DBCPFactory;
import com.vision.dto.BoardDTO;

public class BoardDAO {
	//게시글 등록(본글)
	public void write(String bname, String btitle, String bcontent) {
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		//히트수와 등록일자는 자동으로 들어감(db설계시 디폴트값으로 0과, sysdate를 줌)
		String sql = "INSERT INTO MVC_BOARD(BID,BNAME,BTITLE,BCONTENT,BGROUP,BSTEP,BINDENT) "
				+ " VALUES(MVC_BOARD_SEQ.NEXTVAL,?,?,?,MVC_BOARD_SEQ.CURRVAL,0,0) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			int res = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	//게시글 목록
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> list = new ArrayList();
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//웹페이지에 게시되는 순서를 고려해야함(본글은 내림차순, 게시글은 오름차순)
		String sql = "SELECT * FROM MVC_BOARD "
				+ " ORDER BY BGROUP DESC,BSTEP ASC ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("BID");
				String bname = rs.getString("BNAME");
				String btitle = rs.getString("BTITLE");
				String bcontent = rs.getString("BCONTENT");
				Timestamp bdate = rs.getTimestamp("BDATE");
				int bhit = rs.getInt("BHIT");
				int bgroup = rs.getInt("BGROUP");
				int bstep = rs.getInt("BSTEP");
				int bindent = rs.getInt("BINDENT");
				BoardDTO dto = new BoardDTO(bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent);
				list.add(dto);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return list;
	}
	
	//목록에서 선택 -> 게시글 상세view
	public BoardDTO contentView(String strId) {
		//조회수(hit)하나씩 증가
		upHit(strId);
		BoardDTO dto = null;
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bid = rs.getInt("BID");
				String bname = rs.getString("BNAME");
				String btitle = rs.getString("BTITLE");
				String bcontent = rs.getString("BCONTENT");
				Timestamp bdate = rs.getTimestamp("BDATE");
				int bhit = rs.getInt("BHIT");
				int bgroup = rs.getInt("BGROUP");
				int bstep = rs.getInt("BSTEP");
				int bindent = rs.getInt("BINDENT");
				dto = new BoardDTO(bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				//생성 역순으로 닫아준다.
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
	//조회수증가
	private void upHit(String strId) {
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			int res = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	//게시글 수정(본인것만)
	public void modify(String bid,String bname,String btitle, String bcontent) {
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BNAME=?, BTITLE=?, BCONTENT=? WHERE BID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bid);
			int res = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	//게시글 삭제(본인것만)
	public void delete(String bid) {
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_BOARD WHERE BID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			int res = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	//댓글달기(본글등록과 차이가 있음 - (조회수와 댓글날짜는 자동으로 들어감),그룹, 스탭, 인덴트가 다름)
	public void reply(String bid,String bname,String btitle,
			String bcontent,String bgroup,String bstep,String bindent) {
		
		//이 댓글과 같은 그룹의 댓글중에서 bstep은 이 댓글의 bstep보다 큰놈들은 1씩 증가 = > 이 댓글은 제일 앞
		replyShape(bgroup,bstep);
		
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		//히트수와 등록일자는 자동으로 들어감
		String sql = "INSERT INTO MVC_BOARD(BID,BNAME,BTITLE,BCONTENT,BGROUP,BSTEP,BINDENT) "
				+ " VALUES(MVC_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, Integer.parseInt(bgroup));
			pstmt.setInt(5, Integer.parseInt(bstep)+1);
			pstmt.setInt(6, Integer.parseInt(bindent)+1);
			int res = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	//댓글보기
	public BoardDTO reply_view(String strId) {
		upHit(strId);
		BoardDTO dto = null;
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bid = rs.getInt("BID");
				String bname = rs.getString("BNAME");
				String btitle = rs.getString("BTITLE");
				String bcontent = rs.getString("BCONTENT");
				Timestamp bdate = rs.getTimestamp("BDATE");
				int bhit = rs.getInt("BHIT");
				int bgroup = rs.getInt("BGROUP");
				int bstep = rs.getInt("BSTEP");
				int bindent = rs.getInt("BINDENT");
				dto = new BoardDTO(bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				//생성 역순으로 닫아준다.
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
	
	//댓글정리(중요)
	private void replyShape(String bgroup, String bstep) {
		Connection conn = DBCPFactory.getInstance();
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bgroup));
			pstmt.setInt(2, Integer.parseInt(bstep));
			int res = pstmt.executeUpdate();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	//조회수 증가

}
