package ex0404.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0404.domain.Employee;
import ex0404.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
//DAO : ���� �ϳ��� ��� �ϳ������� ����� ���°Ŵ�.
	@Override
	public List<Employee> selectAll() throws SQLException { //Ʈ�������� ������ �����̴�.
		//�ε� -> static�żҵ� ���ǵǾ��ֱ� ������ ȣ�� ���ص� �ȴ�.
		//����
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select employee_id, last_name, first_name, email, salary from employees");
			//?�� ������ŭ ������� setXXX(����, ��)�� �����Ѵ�.
			rs = ps.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				int salary = rs.getInt(5);
				Employee emp = new Employee(employeeId, firstName, lastName, email, salary);
				list.add(emp);
			}
			
		}
		finally {
			DBUtil.dbClose(con, ps, rs);
		}
		//����
		return list;
	}

	@Override
	public Employee searchById(int employeeId) throws SQLException {// 100 or 1=1
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp =null;
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select employee_id, last_name, first_name, email, salary from employees"
					+ " where employee_id=?");
			//?�� ������ŭ ������� setXXX(����, ��)�� �����Ѵ�.
			ps.setInt(1, employeeId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				int employee_Id = rs.getInt("employee_id");
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				int salary = rs.getInt(5);
				emp = new Employee(employee_Id, firstName, lastName, email, salary);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return emp;
	}

	
	
	@Override
	public int insert(Employee employee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement( " INSERT INTO employees(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, SALARY, hire_date, job_id) " + 
	                " VALUES (?, ?, ?, ?, ?, sysdate, 'AD_PRES') ");
			//?�� ������ŭ ������� setXXX(����, ��)�� �����Ѵ�.
			ps.setInt(1, employee.getEmployeeId());
	        ps.setString(2, employee.getFirstName());
	        ps.setString(3, employee.getLastName());
	        ps.setString(4, employee.getEmail());
	        ps.setInt(5, employee.getSalary());
			
			rs = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		
		return rs;
	}

	@Override
	public int delete(int employeeId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement( "Delete from employees where employee_id=?");
			//?�� ������ŭ ������� setXXX(����, ��)�� �����Ѵ�.
			ps.setInt(1, employeeId);
			rs = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps); // executeUpdate�ÿ��� rs�Ķ���� ���� ���� �ʴ´�.
		}
		return rs;
	}

	@Override
	public int update(Employee employee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement( "update  employees set employee_id = ?, first_name = ?, last_name = ?, email = ?, salary = ? where employee_id=?");
			//?�� ������ŭ ������� setXXX(����, ��)�� �����Ѵ�.
			ps.setInt(1, employee.getEmployeeId());
	        ps.setString(2, employee.getFirstName());
	        ps.setString(3, employee.getLastName());
	        ps.setString(4, employee.getEmail());
	        ps.setInt(5, employee.getSalary());
	        ps.setInt(6, employee.getEmployeeId());
			
			rs = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return rs;
	}



}
