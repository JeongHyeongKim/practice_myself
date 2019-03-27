package gs.mvc.view;

import java.util.Scanner;

import gs.mvc.controler.ElectronicsController;
import gs.mvc.dto.Electronics;

public class StartView {

	public static void searchMenu(Scanner scn) {
		System.out.println("insert modelNo : ");
		int modelNo = scn.nextInt();
		ElectronicsController.searchByModelNo(modelNo);
	}
	
	public static void updateMenu(Scanner scn) {
		System.out.println("insert modelNo");
		int modelNo = scn.nextInt();
		
		System.out.println("insert modelPrice");
		int modelPrice = scn.nextInt();
		
		System.out.println("insert modelDetail");
		String modelDetail = scn.next();
		
		ElectronicsController.update(new Electronics(modelNo, modelPrice, modelDetail));
		
		
	}
	
	public static void insertMenu(Scanner scn) {
		System.out.println("insert modelNo");
		int modelNo = scn.nextInt();
		
		System.out.println("insert modelName");
		String modelName = scn.next();
		
		System.out.println("insert modelPrice");
		int modelPrice = scn.nextInt();
		
		System.out.println("insert modelDetail");
		String modelDetail = scn.next();
		
		ElectronicsController.insert(new Electronics(modelNo, modelName, modelPrice, modelDetail));
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Please Select Menu");
			System.out.println("1. Search All | 2. Search for Paramenter | 3. Insert | 4. Erase | 5. Exit");
			int menuChoice = sc.nextInt();
			switch(menuChoice) {
			case 1:
				ElectronicsController.selectAll();
				break;
			case 2:
				searchMenu(sc);
				break;
			case 3:
				insertMenu(sc);
				break;
			case 4:
				updateMenu(sc);
				break;
			case 5:
				System.out.println("ㅃㅃ");
				System.exit(0); //프로그램 종료
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

}
