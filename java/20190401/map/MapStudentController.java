package map;

public class MapStudentController {
    private static MapStudentService service = new MapStudentService();
	/**
	 * 전체검색
	 * */
	public static void selectAll() {
		//서비스 -> 결과를 받아서 -> EndView호출
		try {
		  EndView.printAll( service.selectAll() );
		  
		}catch (RuntimeException e) {
			//map이 비어 있을때...
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 부분검색
	 * */
	public static void searchById(String id) {
		try {
			Person person = service.searchByKey(id);
			EndView.printSearch(person);
		}catch(RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 등록
	 * */
	public static void insert(Person person) {
		try {
			service.insert(person);
			EndView.printMessage("등록 되었습니다.");
		}catch (RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 삭제
	 * */
    public static void delete(String id) {
    	try {
			service.delete(id);
			EndView.printMessage("삭제 되었습니다.");
		}catch (RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
    
	/**
	 * 수정
	 * */
    public static void update(Person person) {
    	try {
			service.update(person);
			EndView.printMessage("수정 되었습니다.");
		}catch (RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
}








