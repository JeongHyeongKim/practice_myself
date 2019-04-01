package map;

public class MapStudentController {
    private static MapStudentService service = new MapStudentService();
	/**
	 * ��ü�˻�
	 * */
	public static void selectAll() {
		//���� -> ����� �޾Ƽ� -> EndViewȣ��
		try {
		  EndView.printAll( service.selectAll() );
		  
		}catch (RuntimeException e) {
			//map�� ��� ������...
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * �κа˻�
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
	 * ���
	 * */
	public static void insert(Person person) {
		try {
			service.insert(person);
			EndView.printMessage("��� �Ǿ����ϴ�.");
		}catch (RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * ����
	 * */
    public static void delete(String id) {
    	try {
			service.delete(id);
			EndView.printMessage("���� �Ǿ����ϴ�.");
		}catch (RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
    
	/**
	 * ����
	 * */
    public static void update(Person person) {
    	try {
			service.update(person);
			EndView.printMessage("���� �Ǿ����ϴ�.");
		}catch (RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
}








