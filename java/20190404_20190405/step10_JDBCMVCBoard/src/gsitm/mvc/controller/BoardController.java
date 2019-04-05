package gsitm.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import gsitm.mvc.model.dto.BoardDTO;
import gsitm.mvc.model.service.BoardService;
import gsitm.mvc.model.service.BoardServiceImpl;
import gsitm.mvc.view.FailView;
import gsitm.mvc.view.SuccessView;

public class BoardController {
	private static BoardService boardService = new BoardServiceImpl();

	/**
	 * 모든레코드 검색
	 */
	public static void boardSelectByAll() {
		// 서비스 -> DAO -> 그 결과 받아서...
		try {
			List<BoardDTO> list = boardService.boardSelectAll();
			SuccessView.selectPrint(list);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 제목에 특정한 문자열 포함된 레코드 검색
	 */
	public static void boardSelectBySubject(String keyWord) {
		try{
			List<BoardDTO> list = boardService.boardSelectBySubject(keyWord);
			SuccessView.selectPrint(list);
		} catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 글번호에 해당하는 레코드 검색
	 */
	public static void boardSelectByNo(int boardNo) {
		try {
			BoardDTO boardDTO = boardService.boardSelectByNo(boardNo);
			SuccessView.selectByNoPrint(boardDTO);
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 레코드 등록
	 */
	public static void boardInsert(BoardDTO boardDTO) {
		try {
			boardService.boardInsert(boardDTO);
			SuccessView.messagePrint("등록되었습니다.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 레코드 수정
	 */
	public static void boardUpdate(BoardDTO boardDTO) {
		try {
			boardService.boardUpdate(boardDTO);
			SuccessView.messagePrint(boardDTO.getBoardNo() + "번호의 게시물이 수정되었습니다.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 레코드 삭제
	 */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			SuccessView.messagePrint(boardNo + "번호의 게시물이 삭제되었습니다.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
