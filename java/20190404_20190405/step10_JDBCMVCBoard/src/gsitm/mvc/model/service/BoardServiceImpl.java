package gsitm.mvc.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gsitm.mvc.model.dao.BoardDAO;
import gsitm.mvc.model.dao.BoardDAOImpl;
import gsitm.mvc.model.dto.BoardDTO;

public class BoardServiceImpl implements BoardService{
	private BoardDAO btDAO = new BoardDAOImpl();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		List<BoardDTO> list = btDAO.boardSelectAll();
		
		if(list==null | list.size()==0 | list.isEmpty()) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> list = btDAO.boardSelectBySubject(keyWord);
		
		if(list==null | list.size()==0|list.isEmpty()) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO bt = btDAO.boardSelectByNo(boardNo);
		
		if(bt==null)
			throw new SQLException("검색된 레코드가 없습니다.");
		
		return bt;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		int result = btDAO.boardInsert(boardDTO);
		
		if(result==0) {
			throw new SQLException("Error in Insert");
		}
		
		
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		int result = btDAO.boardUpdate(boardDTO);
		
		if(result==0) {
			throw new SQLException("Error in Update");
		}
		
		
	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		int result = btDAO.boardDelete(boardNo);
		
		if(result==0) {
			throw new SQLException("Error in Delete");
		}
		
		
	}

}
