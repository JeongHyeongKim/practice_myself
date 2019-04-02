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

	Map<String,Map<String,Board>> allBoardList = new TreeMap<>(); // Ű�� ���ĵǴ� ģ����.

	private BoardServiceImpl() {
		Map<String,Board> archiveMap= new TreeMap<>();
		Map<String,Board> photoMap= new TreeMap<>();
		//archiveInfo.properties ���Ϸε�
		// properties�� map�� ��ӹ���

		ResourceBundle rb = 
				ResourceBundle.getBundle("gsitm/exam/model/service/archiveInfo");
		Iterator<String> keys = rb.keySet().iterator();

		while(keys.hasNext()) {
			String key = keys.next();
			String[] value = rb.getString(key).split(","); // �޸��� �������� �كD��.
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

		//System.out.println(allBoardList); �ʱ�ġ ������ �ҷ����� ����!
	}

	public static BoardService getInstance() {
		return instance;
	}

	


	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		if(allBoardList == null  || allBoardList.isEmpty() ) {
			throw new InexistentException("�Խù��� �������� �ʽ��ϴ�.");
		}
		
		Iterator<String> keys = allBoardList.keySet().iterator();
		while(keys.hasNext()) {
		  if(!allBoardList.get(keys.next()).isEmpty()) {
			 return allBoardList;  
		  }
		}
		
		throw new InexistentException("� �Խ��� �������� �Խù��� �����ϴ�.");
	}

	/**
	 *�Խ���������(Kind)�� ���� �Խù� �˻��ϱ�
	 *  @return kind�� �ش��ϴ� ��ü�Խù� Map���� ����
	 *  @param :  �Խù������� ���� key�� �μ��� ���޹޴´�.
	 *  @throws : kind�� �ش��ϴ� �Խù��� �Ѱ��� ���� �� InexistentException���ܹ߻�
	 *  kind = > AB, PB ���� �ϳ� 
	 * */

	
	/*Map<String,Map<String,Board>> allBoardList = new TreeMap<>(); // Ű�� ���ĵǴ� ģ����.

	private BoardServiceImpl() {
		Map<String,Board> archiveMap= new TreeMap<>();
		Map<String,Board> photoMap= new TreeMap<>();*/
	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		
		if(allBoardList.get(kind)==null) {
			throw new InexistentException("�ش� �Խ����� �������� �ʽ��ϴ�.");
		}
		else
			return allBoardList.get(kind);

	}

	/**
	 *  �Խù� �������� �۹�ȣ�� �ش��ϴ� �Խù� �Ѱ��� �˻�
	 * @return �Խù� ���� �Ѱ��� Board ���·� ����
	 * @param kind�� �Խù� ����, no�� �Խù� �۹�ȣ
	 * @throws �˻��ϴ� �Խù��� ������ InexistentException ���ܹ߻�
	 * kind �߸��̸� kind exception
	 * */

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //�ش� �Խ����� ��ü�� �޾ƿ´�.
		
		Board board= map.get(String.valueOf(no)); //�޾ƿ� �Խ��ǿ��� no�� ���� ã�´�. ������ null��ȯ�ǰ���?
		if(board==null)
			throw new InexistentException("�Խù��� �������� �ʽ��ϴ�.");
		else
			return board;
		
	}


	/**
	 *  �Խù� ����ϱ�
	 *  @return : true�̸�  ��ϼ���, false�̸� ��Ͻ���
	 *  @param : kind�� �߰��� �Խ�������, board�� �߰��� �Խù��� ����
	 *  @throws: ����ϱ� ���� �۹�ȣ �ߺ��� üũ�ؼ� �ߺ��̸� DuplicateException�߻�
	 *           ����� �����ϸ�  InexistentException �߻�
	 * */
	
	//kind -> mapmap�� �ĺ���
	@Override
	public boolean insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //�Խ��� ���� ����?
		
		Board paramExist = map.get(board.getNo()); //���� �����ϴ°�?
		if(paramExist==null)
			throw new DuplicateException("�ߺ��Ǵ� ���� �ֽ��ϴ�."); //����ó��
		else { //���� ���� �� ����ȴ�.
				if(board instanceof ArchiveBoard) {
					ArchiveBoard ab = (ArchiveBoard) board; // ����ڷκ��� �޾ƿ� ��ü�� �ٿ�ĳ����
					Map<String, Board> buf = new TreeMap(); //allBoardList�� ���� Map�� ����
		
					buf.put(String.valueOf(ab.getNo()), ab); //�� ���Ŀ� �°� ���� ��, 
					allBoardList.put(kind, buf); //��¥ �־��ִ°Ŵ�.
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
	 * 5. ������� ��ȣ �ߺ����� üũ �ϴ� ���
	 *    @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�.
	 *    @param : kind�� �Խ����� ����, no�� �۹�ȣ
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
	 * 6. �Խù� �����ϱ�
	 *  @return : true�̸� ��������, false�̸� ��������
	 *  @param : kind�� �Խ����� ����, no�� �۹�ȣ
	 *  @throws : ������ ���� ������ InexistentException ���� �߻�.
	 * */

	@Override
	public boolean deleteBoard(String kind, int no) throws InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //�Խ��� ���� ����?
		
		Board paramExist = map.get(String.valueOf(no)); //���� �����ϴ°�?
		if(paramExist==null) {
			throw new InexistentException("�ش��ϴ� ���� �����ϴ�.");
		}
		else
			allBoardList.remove(kind,paramExist);
		
		return true;
	}

	/**
	 * 7. �Խù� �����ϱ�
	 *     ���� : ����, �ۼ���, ����
	 *     photo : imgName
	 *     archive : fileName, fileSize
	 *     
	 * @return :true�̸� ��������, false�̸� ��������
	 * @param : board�� ������ �Խù��� ����, kind�� ������ �Խù����ִ� �Խ���������
	 * @throws: �������� ������ InexistentException ���ܹ߻�
	 * */

	@Override
	public boolean updateBoard(Board board, String kind) throws InexistentException {
		Map <String, Board> map = getBoardByKind(kind); //�Խ��� ���� ����?
		
		Board paramExist = map.get(String.valueOf(board.getNo())); //���� �����ϴ°�?
		if(paramExist==null)
			throw new InexistentException("�ش� ���� �������� �ʽ��ϴ�.");
		else {
			Map<String, Board> buf = new TreeMap();
			buf.put(String.valueOf(String.valueOf(board.getNo())), board);
			allBoardList.put(kind, buf);
		}
		return true;
	}
}

