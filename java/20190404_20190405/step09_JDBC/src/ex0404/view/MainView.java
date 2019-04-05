package ex0404.view;

import ex0404.controller.EmployeeController;
import ex0404.domain.Employee;

public class MainView {

	public static void main(String[] args) {
		System.out.println("1. 전체 검색");
		EmployeeController.selectAll();
		System.out.println();
		
		/*System.out.println("2. ID 검색");
		EmployeeController.searchById(103);
		System.out.println();
		
		System.out.println("3. 등록하기");
		Employee em = new Employee(10001,"aA","aaA","sadsaA",202020);
		EmployeeController.insert(em);
		EmployeeController.selectAll();
		System.out.println();
		
		System.out.println("4. 수정하기");	
		Employee em1 = new Employee(10001,"aA","aaA","sadsaA",111111);
		EmployeeController.update(em1);
		EmployeeController.selectAll();
		System.out.println();
		
		System.out.println("5. 삭제하기");
		EmployeeController.delete(10001);
		EmployeeController.selectAll();*/
	}

}
