package gsitm.mvc.view;

import java.util.List;

import gsitm.mvc.model.dto.BoardDTO;

public class SuccessView {
	public SuccessView() {}
	
	public static void selectPrint(List <BoardDTO> list) {
		System.out.println(list);
		
	}

	public static void selectByNoPrint(BoardDTO bt) {
		System.out.println(bt);
		
	}
	
	public static void messagePrint(String msg) {
		System.out.println(msg);
	}
}
