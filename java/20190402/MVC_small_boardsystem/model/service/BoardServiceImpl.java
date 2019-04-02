package gsitm.exam.model.service;

import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import gsitm.exam.model.dto.ArchiveBoard;
import gsitm.exam.model.dto.Board;
import gsitm.exam.model.dto.PhotoBoard;
import gsitm.exam.model.util.DuplicateException;
import gsitm.exam.model.util.InexistentException;

public class BoardServiceImpl implements BoardService {

	private static BoardService instance = new BoardServiceImpl();

	Map<String,Map<String,Board>> allBoardList = new TreeMap<>(); // 키가 정렬되는 친구임.

	private BoardServiceImpl() {
		Map<String,Board> archiveMap= new TreeMap<>();
		Map<String,Board> photoMap= new TreeMap<>();
		//archiveInfo.properties 파일로딩
		// properties가 map을 상속받음

		ResourceBundle rb = 
				ResourceBundle.getBundle("gsitm/exam/model/service/archiveInfo");
		Iterator<String> keys = rb.keySet().iterator();

		while(keys.hasNext()) {
			String key = keys.next();
			String[] value = rb.getString(key).split(","); // 콤마를 기준으로 다귾음.
			Board board = new ArchiveBoard(Integer.parseInt(value[0]),value[1],value[2],value[3],value[4],value[5],Integer.parseInt(value[6]));
			archiveMap.put(key,board);
		}

		rb = ResourceBundle.getBundle("gsitm/exam/model/service/photoInfo");
		keys = rb.keySet().iterator();

		while(keys.hasNext()) {
			String key = keys.next();
			String[] value = rb.getString(key).split(",");
			Board board = new PhotoBoard(Integer.parseInt(value[0]),value[1],value[2],value[3],value[4],value[5]);
			photoMap.put(key,board);
		}
		allBoardList.put("archive", archiveMap);
		allBoardList.put("photo", photoMap);

		//System.out.println(allBoardList); 초기치 데이터 불러오기 성공!
	}

	public static BoardService getInstance() {
		return instance;
	}

	


	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		if(allBoardList == null  || allBoardList.isEmpty() ) {
			throw new InexistentException("게시물이 존재하지 않습니다.");
		}
		
		Iterator<String> keys = allBoardList.keySet().iterator();
		while(keys.hasNext()) {
		  if(!allBoardList.get(keys.next()).isEmpty()) {
			 return allBoardList;  
		  }
		}
		
		throw new InexistentException("어떤 게시판 유형에도 게시물이 없습니다.");
	}

	/**
	 *게시판의유형(Kind)에 따른 게시물 검색하기
	 *  @return kind에 해당하는 전체게시물 Map으로 리턴
	 *  @param :  게시물유형에 따른 key를 인수로 전달받는다.
	 *  @throws : kind에 해당하는 게시물이 한개도 없을 때 InexistentException예외발생
	 *  kind = > AB, PB 둘중 하나 
	 * */

	
	/*Map<String,Map<String,Board>> allBoardList = new TreeMap<>(); // 키가 정렬되는 친구임.

	private BoardServiceImpl() {
		Map<String,Board> archiveMap= new TreeMap<>();
		Map<String,Board> photoMap= new TreeMap<>();*/
	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		
		if(allBoardList.get(kind)==null) {
			throw new InexistentException("해당 게시판이 존재하지 않습니다.");
		}
		else
			return allBoardList.get(kind);

	}

	/**
	 *  게시물 유형에서 글번호에 해당하는 게시물 한개를 검색
	 * @return 게시물 정보 한개를 Board 형태로 리턴
	 * @param kind는 게시물 유형, no는 게시물 글번호
	 * @throws 검색하는 게시물이 없으면 InexistentException 예외발생
	 * kind 잘못이면 kind exception
	 * */

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //해당 게시판의 객체를 받아온다.
		
		Board board= map.get(String.valueOf(no)); //받아온 게시판에서 no로 글을 찾는다. 없으면 null반환되겠지?
		if(board==null)
			throw new InexistentException("게시물이 존재하지 않습니다.");
		else
			return board;
		
	}


	/**
	 *  게시물 등록하기
	 *  @return : true이면  등록성공, false이면 등록실패
	 *  @param : kind는 추가할 게시판유형, board는 추가할 게시물의 정보
	 *  @throws: 등록하기 전에 글번호 중복을 체크해서 중복이면 DuplicateException발생
	 *           등록을 실패하면  InexistentException 발생
	 * */
	
	//kind -> mapmap의 식별자
	@Override
	public boolean insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //게시판 존재 유무?
		
		Board paramExist = map.get(board.getNo()); //글이 존재하는가?
		if(paramExist==null)
			throw new DuplicateException("중복되는 글이 있습니다."); //예외처리
		else { //에러 없을 대 진행된다.
				if(board instanceof ArchiveBoard) {
					ArchiveBoard ab = (ArchiveBoard) board; // 사용자로부터 받아온 객체를 다운캐스팅
					Map<String, Board> buf = new TreeMap(); //allBoardList에 넣을 Map의 형식
		
					buf.put(String.valueOf(ab.getNo()), ab); //그 형식에 맞게 대입 후, 
					allBoardList.put(kind, buf); //진짜 넣어주는거다.
				} else if(board instanceof PhotoBoard) {
					PhotoBoard  pb = (PhotoBoard) board;
					Map<String, Board> buf = new TreeMap();
					
					buf.put(String.valueOf(pb.getNo()), pb);
					allBoardList.put(kind,buf);
				}
		}
		return true;
	}

	/**
	 * 5. 등록전에 번호 중복여부 체크 하는 기능
	 *    @return : true이면 중복, false이면 중복아님.
	 *    @param : kind의 게시판의 유형, no는 글번호
	 * */

	@Override
	public boolean duplicateByNo(String kind, int no)  {
		try {
			Map <String, Board> map = getBoardByKind(kind);
			if(map.get(no)!=null)
				return false;
			else
				return true;
		} catch (InexistentException e) {
		}
		return false;
		
	}

	/**
	 * 6. 게시물 삭제하기
	 *  @return : true이면 삭제성공, false이면 삭제실패
	 *  @param : kind의 게시판의 유형, no는 글번호
	 *  @throws : 삭제가 되지 않으면 InexistentException 예외 발생.
	 * */

	@Override
	public boolean deleteBoard(String kind, int no) throws InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //게시판 존재 유무?
		
		Board paramExist = map.get(String.valueOf(no)); //글이 존재하는가?
		if(paramExist==null) {
			throw new InexistentException("해당하는 글이 없습니다.");
		}
		else
			allBoardList.remove(kind,paramExist);
		
		return true;
	}

	/**
	 * 7. 게시물 수정하기
	 *     공통 : 제목, 작성자, 내용
	 *     photo : imgName
	 *     archive : fileName, fileSize
	 *     
	 * @return :true이면 수정성공, false이면 수정실패
	 * @param : board는 수정할 게시물의 정보, kind는 수정될 게시물이있는 게시판의유형
	 * @throws: 수정되지 않으면 InexistentException 예외발생
	 * */

	@Override
	public boolean updateBoard(Board board, String kind) throws InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //게시판 존재 유무?
		
		Board paramExist = map.get(String.valueOf(board.getNo())); //글이 존재하는가?
		if(paramExist==null)
			throw new InexistentException("해당 글이 존재하지 않습니다.");
		else {
			Map<String, Board> buf = new TreeMap();
			buf.put(String.valueOf(String.valueOf(board.getNo())), board);
			allBoardList.put(kind, buf);
		}
		return true;
	}
}

