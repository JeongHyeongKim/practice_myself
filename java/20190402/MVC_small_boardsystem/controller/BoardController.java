package gsitm.exam.controller;

import java.util.Map;

import gsitm.exam.model.dto.Board;
import gsitm.exam.model.service.BoardService;
import gsitm.exam.model.service.BoardServiceImpl;
import gsitm.exam.model.util.InexistentException;
import gsitm.exam.view.FailView;
import gsitm.exam.view.SuccessView;

public class BoardController {
	private static BoardService boardService=BoardServiceImpl.getInstance();
	
	public static void getAllBoard(){
		try {
			SuccessView.printBoard(boardService.getBoardList());
		}catch (InexistentException e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void getBoardByKind(String kind){
		try {
            Map<String, Board> kindMap=boardService.getBoardByKind(kind);
			SuccessView.printBoardByKind(kind , kindMap);
		} catch (Exception e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void getBoardByno(String kind, int no){//
		try {
			SuccessView.printBoardByNo(boardService.getBoardByNo(kind,no));
		} catch(InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
		

	}
	
	
	
	public static void insertBoard(String kind, Board board) {
		try {
			boardService.insertBoard(kind, board);
			SuccessView.printMessage("등록 완료");
		} catch (Exception e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void deleteBoard(String kind, int no){//
		try {
			boardService.deleteBoard(kind, no);
			SuccessView.printMessage("삭제 완료");
		} catch(InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	public static void updateBoard(Board board, String kind) {//
		try {
			boardService.updateBoard(board, kind);
			SuccessView.printMessage("수정 완료");
		} catch(InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
}
