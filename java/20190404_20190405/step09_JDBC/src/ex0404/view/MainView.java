package ex0404.view;

import ex0404.controller.EmployeeController;
import ex0404.domain.Employee;

public class MainView {

	public static void main(String[] args) {
		System.out.println("1. ��ü �˻�");
		EmployeeController.selectAll();
		System.out.println();
		
		/*System.out.println("2. ID �˻�");
		EmployeeController.searchById(103);
		System.out.println();
		
		System.out.println("3. ����ϱ�");
		Employee em = new Employee(10001,"aA","aaA","sadsaA",202020);
		EmployeeController.insert(em);
		EmployeeController.selectAll();
		System.out.println();
		
		System.out.println("4. �����ϱ�");	
		Employee em1 = new Employee(10001,"aA","aaA","sadsaA",111111);
		EmployeeController.update(em1);
		EmployeeController.selectAll();
		System.out.println();
		
		System.out.println("5. �����ϱ�");
		EmployeeController.delete(10001);
		EmployeeController.selectAll();*/
	}

}
