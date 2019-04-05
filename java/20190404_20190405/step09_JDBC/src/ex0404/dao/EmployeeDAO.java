package ex0404.dao;

import java.sql.SQLException;
import java.util.List;

import ex0404.domain.Employee;

public interface EmployeeDAO { //DAO�� ���� ����?
	/*
	 * ��ü �˻�
	 */
	List<Employee> selectAll() throws SQLException;
	
	/*
	 * id(pk)�� �ش��ϴ� ��� �˻��ϱ�
	 */
	Employee searchById(int employeeId) throws SQLException;
	
	/*
	 * ����ϱ�
	 */
	int insert(Employee employee) throws SQLException;
	
	/*
	 * �����ϱ�
	 */
	int delete(int employeeId) throws SQLException;
	
	/*
	 * �����ϱ�(���̵� �ش��ϴ� ��� first_name, last_name, email, salary ����)
	 */
	int update(Employee employee) throws SQLException;
	
	

}
