package ex0404.dao;

import java.sql.SQLException;
import java.util.List;

import ex0404.domain.Employee;

public interface EmployeeDAO { //DAO가 무슨 약자?
	/*
	 * 전체 검색
	 */
	List<Employee> selectAll() throws SQLException;
	
	/*
	 * id(pk)에 해당하는 사원 검색하기
	 */
	Employee searchById(int employeeId) throws SQLException;
	
	/*
	 * 등록하기
	 */
	int insert(Employee employee) throws SQLException;
	
	/*
	 * 삭제하기
	 */
	int delete(int employeeId) throws SQLException;
	
	/*
	 * 수정하기(아이디에 해당하는 사원 first_name, last_name, email, salary 수정)
	 */
	int update(Employee employee) throws SQLException;
	
	

}
