package gsitm.mvc.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import gsitm.mvc.model.util.*;
import gsitm.mvc.model.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO{
	
	private static Properties proFile =  new Properties();
	

	static {
		try {
			//2개의 proerties파일 로딩하기!
			proFile.load(new FileInputStream("properties/board.properties"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		List <BoardDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			
			ps=con.prepareStatement(proFile.getProperty("board.selectAll"));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String board_date = rs.getString("board_date");
				
				BoardDTO bt = new BoardDTO(boardNo, subject, writer,content, board_date);
				list.add(bt);
			}
		}
		finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	/*board_no int primary key, --글번호
	subject varchar2(30) not null, --제목
	writer varchar2(20) not null,--작성자
	content varchar2(50) not null, -- 내용
	board_date date not null -- 작성일*/
	
	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List <BoardDTO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			
			ps=con.prepareStatement(proFile.getProperty("board.selectBySubject"));
			ps.setString(1, keyWord);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String board_date = rs.getString("board_date");
				
				BoardDTO bt = new BoardDTO(boardNo, subject, writer,content, board_date);
				list.add(bt);
			}
		}
		finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTO bt = null;
		
		try {
			con=DbUtil.getConnection();
			
			ps=con.prepareStatement(proFile.getProperty("board.selectByNo"));
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int boardno = rs.getInt("board_no");
				String subject = rs.getString("subject");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String board_date = rs.getString("board_date");
				
				bt = new BoardDTO(boardno, subject, writer,content, board_date);
			}
		}
		finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return bt;
		
		
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;

		
		try {
			con=DbUtil.getConnection();
			//insert into board (board_no, subject, writer, content, board_date) values (board_seq1.nextval, ?, ?, ?, sysdate)
			ps=con.prepareStatement(proFile.getProperty("board.insert"));
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent() );
			
			rs = ps.executeUpdate();
			} finally {
			DbUtil.dbClose(ps, con);
		}
		return rs;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;

		
		try {
			con=DbUtil.getConnection();
			//update board set content = ?  where board_no = ?
			ps=con.prepareStatement(proFile.getProperty("board.updateByNo"));
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			rs = ps.executeUpdate();
			} finally {
			DbUtil.dbClose(ps, con);
		}
		return rs;
	}

	@Override
	public int boardDelete(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;

		try {
			con=DbUtil.getConnection();
			//delete from board where board_no = ?
			ps=con.prepareStatement(proFile.getProperty("board.deleteByNo"));
			ps.setInt(1, boardNo);
			
			rs = ps.executeUpdate();
			} finally {
			DbUtil.dbClose(ps, con);
		}
		return rs;
	}

}
