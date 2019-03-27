package gs.mvc.view;

import gs.mvc.dto.Electronics;
import gs.mvc.service.ElectronicsService;

public class EndView {
	
	//public EndView() {
		
	//}
	
	//전체 전자제품 출력
	public static void printAll (Electronics[] elecArr) {
		System.out.println("List of Electronics");
		for(int i=0;i<ElectronicsService.count;i++) {
			System.out.print("modelNo : "+elecArr[i].getModelNo()+ " | ");
			System.out.print("modelName : "+elecArr[i].getModelName()+ " | ");
			System.out.print("modelPrice : "+elecArr[i].getModelPrice()+ " | ");
			System.out.print("modelDetail : "+elecArr[i].getModelDetail()+ " \n");
		}
		System.out.println();
	}

	//모델번호에 해당하는 제품 정보 출력
	public static void printSearch (Electronics elec) {
		System.out.println("해당하는 모델의 상세입니다");
		System.out.print("modelNo : "+elec.getModelNo()+ " | ");
		System.out.print("modelName : "+elec.getModelName()+ " | ");
		System.out.print("modelPrice : "+elec.getModelPrice()+ " | ");
		System.out.print("modelDetail : "+elec.getModelDetail()+ " \n");
		System.out.println();
		
	}	
	
	//수정or등록 결과메시지 출력
	public static void printMessage(String msg) {
		System.out.println(msg);
		System.out.println();
		
	}
}
