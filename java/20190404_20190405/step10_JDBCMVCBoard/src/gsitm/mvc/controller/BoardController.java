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
	 * ��緹�ڵ� �˻�
	 */
	public static void boardSelectByAll() {
		// ���� -> DAO -> �� ��� �޾Ƽ�...
		try {
			List<BoardDTO> list = boardService.boardSelectAll();
			SuccessView.selectPrint(list);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ���� Ư���� ���ڿ� ���Ե� ���ڵ� �˻�
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
	 * �۹�ȣ�� �ش��ϴ� ���ڵ� �˻�
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
	 * ���ڵ� ���
	 */
	public static void boardInsert(BoardDTO boardDTO) {
		try {
			boardService.boardInsert(boardDTO);
			SuccessView.messagePrint("��ϵǾ����ϴ�.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ���ڵ� ����
	 */
	public static void boardUpdate(BoardDTO boardDTO) {
		try {
			boardService.boardUpdate(boardDTO);
			SuccessView.messagePrint(boardDTO.getBoardNo() + "��ȣ�� �Խù��� �����Ǿ����ϴ�.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ���ڵ� ����
	 */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			SuccessView.messagePrint(boardNo + "��ȣ�� �Խù��� �����Ǿ����ϴ�.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
