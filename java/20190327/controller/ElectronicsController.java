package gs.mvc.controler;

import gs.mvc.dto.Electronics;
import gs.mvc.service.ElectronicsService;
import gs.mvc.view.EndView;

public class ElectronicsController {
	static ElectronicsService service = ElectronicsService.getService();
	static Electronics[] elecArr = service.selectAll();
	

	public ElectronicsController(){
		
		
	}
	
	public static void selectAll() {
		//���񽺸� ȣ���ϰ� �� ����� �޾Ƽ� ����並 ȣ���Ѵ�.
		Electronics[] elecArr = service.selectAll();
		EndView.printAll(elecArr);
		
	}
	
	public static void searchByModelNo(int modelNo) {
		Electronics result = service.searchByModelNo(modelNo);
		if(result!=null)
			EndView.printSearch(result);
		else
			EndView.printMessage("�ش� ���� �������� �ʽ��ϴ�.");;
	}
	
	public static void update(Electronics elec) {
		if(service.update(elec))
			EndView.printMessage("������Ʈ ����");
		else
			EndView.printMessage("������Ʈ ����! ��ǰ��ȣ�� Ȯ�����ּ���");
		
	}
	
	public static void insert(Electronics elec) {
		if(service.insert(elec))
			EndView.printMessage("insert ����");
		else
			EndView.printMessage("modelNo �Ǵ� modelName �� �ߺ��� ���� �ֽ��ϴ�.");
		
	}
}
