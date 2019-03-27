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
		//서비스를 호출하고 그 결과를 받아서 결과뷰를 호출한다.
		Electronics[] elecArr = service.selectAll();
		EndView.printAll(elecArr);
		
	}
	
	public static void searchByModelNo(int modelNo) {
		Electronics result = service.searchByModelNo(modelNo);
		if(result!=null)
			EndView.printSearch(result);
		else
			EndView.printMessage("해당 모델은 존재하지 않습니다.");;
	}
	
	public static void update(Electronics elec) {
		if(service.update(elec))
			EndView.printMessage("업데이트 성공");
		else
			EndView.printMessage("업데이트 실패! 제품번호를 확인해주세요");
		
	}
	
	public static void insert(Electronics elec) {
		if(service.insert(elec))
			EndView.printMessage("insert 성공");
		else
			EndView.printMessage("modelNo 또는 modelName 중 중복된 값이 있습니다.");
		
	}
}
