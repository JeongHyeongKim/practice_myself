package ex0328.good;

public class FullTime extends Employee{

	private int salary;
	private int bonus;
	
	public FullTime() {}
	
	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary, int bonus) {
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.salary = salary;
		this.bonus = bonus;
		// TODO Auto-generated constructor stub
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(salary+" | ");

		builder.append(bonus);
		return builder.toString();
	}

	@Override
	void message() {
		System.out.println(super.geteName()+"사원은 정규직입니다.");
		// TODO Auto-generated method stub
		
	}

}
