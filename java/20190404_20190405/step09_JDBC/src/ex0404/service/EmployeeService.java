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
	 * ��ü�˻�
	 */
	public List<Employee> selectAll() throws SQLException{
		List<Employee> list = empDAO.selectAll();
		
		if(list==null | list.size()==0 | list.isEmpty()) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return list;
	}
	
	/*
	 * ���̵� ��� �˻�
	 */
	public Employee searchById(int employeeId) throws SQLException {
		Employee em = empDAO.searchById(employeeId);
		
		if(em==null)
			throw new SQLException("�ش� ���ڵ�� �������� �ʴ� ���ڵ��Դϴ�.");
		else
			return em;
		
		
	} 
	
	/*
	 * ���
	 */
	
	public int insert(Employee em) throws SQLException{
		int result = empDAO.insert(em);
		
		if(result==0) 
			throw new SQLException("�ߺ��Ǵ� ID���� �����մϴ�");
		else
			return result;
	}
	
	/*
	 * ����
	 */
	
	public int delete(int employeeId) throws SQLException{
		int result = empDAO.delete(employeeId);
		
		if(result==0) 
			throw new SQLException("�ش��ϴ� ����� ����� �������� �ʽ��ϴ�.");
		else
			return result;
			
	}
	/* 
	 * ����
	 */
	
	public int update(Employee em) throws SQLException{
		int result = empDAO.update(em);
		
		if(result==0)
			throw new SQLException("�ش� �ϴ� ����� ����� �������� �ʽ��ϴ�.");
		else
			return result;
	}

	
}
