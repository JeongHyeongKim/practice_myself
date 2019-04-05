package ex0404.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ex0404.dao.EmployeeDAO;
import ex0404.dao.EmployeeDAOImpl;
import ex0404.domain.Employee;
import ex0404.util.DBUtil;

public class EmployeeService {
	private EmployeeDAO empDAO = new EmployeeDAOImpl();

	/*
	 * 전체검색
	 */
	public List<Employee> selectAll() throws SQLException{
		List<Employee> list = empDAO.selectAll();
		
		if(list==null | list.size()==0 | list.isEmpty()) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}
	
	/*
	 * 아이디 기반 검색
	 */
	public Employee searchById(int employeeId) throws SQLException {
		Employee em = empDAO.searchById(employeeId);
		
		if(em==null)
			throw new SQLException("해당 레코드는 존재하지 않는 레코드입니다.");
		else
			return em;
		
		
	} 
	
	/*
	 * 등록
	 */
	
	public int insert(Employee em) throws SQLException{
		int result = empDAO.insert(em);
		
		if(result==0) 
			throw new SQLException("중복되는 ID값이 존재합니다");
		else
			return result;
	}
	
	/*
	 * 삭제
	 */
	
	public int delete(int employeeId) throws SQLException{
		int result = empDAO.delete(employeeId);
		
		if(result==0) 
			throw new SQLException("해당하는 사번의 사원이 존재하지 않습니다.");
		else
			return result;
			
	}
	/* 
	 * 수정
	 */
	
	public int update(Employee em) throws SQLException{
		int result = empDAO.update(em);
		
		if(result==0)
			throw new SQLException("해당 하는 사번의 사원이 존재하지 않습니다.");
		else
			return result;
	}

	
}
