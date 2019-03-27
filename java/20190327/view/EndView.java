package gs.mvc.view;

import gs.mvc.dto.Electronics;
import gs.mvc.service.ElectronicsService;

public class EndView {
	
	//public EndView() {
		
	//}
	
	//��ü ������ǰ ���
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

	//�𵨹�ȣ�� �ش��ϴ� ��ǰ ���� ���
	public static void printSearch (Electronics elec) {
		System.out.println("�ش��ϴ� ���� ���Դϴ�");
		System.out.print("modelNo : "+elec.getModelNo()+ " | ");
		System.out.print("modelName : "+elec.getModelName()+ " | ");
		System.out.print("modelPrice : "+elec.getModelPrice()+ " | ");
		System.out.print("modelDetail : "+elec.getModelDetail()+ " \n");
		System.out.println();
		
	}	
	
	//����or��� ����޽��� ���
	public static void printMessage(String msg) {
		System.out.println(msg);
		System.out.println();
		
	}
}
