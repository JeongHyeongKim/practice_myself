package ex0404.controller;

import java.sql.SQLException;
import java.util.List;

import ex0404.domain.Employee;
import ex0404.service.EmployeeService;
import ex0404.view.SuccessView;
import ex0404.view.FailView;

public class EmployeeController {
	private static EmployeeService service = new EmployeeService();
	
	
	/**
	 * 검색
	 */
	public static void selectAll() {
		try {
			List<Employee> list = service.selectAll();
			SuccessView.printAll(list);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void searchById(int employeeId) {
		try {
			Employee em = service.searchById(employeeId);
			SuccessView.printOne(em);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 부분검색
	 */
	
	/**
	 * 등록
	 */
	public static void insert(Employee em) {
		try {
			int result = service.insert(em);
			SuccessView.printMessage("입력 성공");
		} catch(SQLException e) {
			FailView.printMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 수정
	 */
	
	public static void update(Employee em) {
		try {
			int result = service.update(em);
			SuccessView.printMessage("수정 성공");
		} catch(SQLException e) {
			FailView.printMessage(e.getMessage());
			e.printStackTrace();
		}
		
	}
	/**
	 * 삭제
	 */

	public static void delete(int employeeId) {
		try {
			int result = service.delete(employeeId);
			SuccessView.printMessage("삭제 성공");
		} catch(SQLException e) {
			FailView.printMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
