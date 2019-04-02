package gsitm.exam.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import gsitm.exam.model.dto.ArchiveBoard;
import gsitm.exam.model.dto.Board;
import gsitm.exam.model.dto.PhotoBoard;

public class SuccessView {

	public static void printBoard(Map<String,Map<String,Board>> map) {
		
		Iterator<String> iterBig = map.keySet().iterator(); // 큰  맵의 이터레이터
		while(iterBig.hasNext()) {
			String keyBig = iterBig.next(); 
			
			Iterator<String> iterSmall = map.get(keyBig).keySet().iterator(); // 작은 맵의 이터레이터
			while(iterSmall.hasNext()) {
				String keySmall = iterSmall.next();
				Board buf = map.get(keyBig).get(keySmall);
				if(buf  instanceof PhotoBoard)
					System.out.println(buf+" | PhotoBoard");
				else if(buf instanceof ArchiveBoard)
					System.out.println(buf+ " | ArchiveBoard");
				
			}
			
		}
		
		

		
	}
	
	public static void printBoardByKind(String kind , Map<String,Board> map) {
		System.out.println(kind+"의 모든 게시물 List");
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(map.get(key));
		}
		
	}
	
	public static void printBoardByNo(Board board) {
		System.out.println(board);
	}
	
	public static void printMessage(String msg) {
		System.out.println(msg);
	}
	
}
