package ex0328.good;

public class PartTime extends Employee{
	private int timePay;
	
	public PartTime() {}

	public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.timePay=timePay;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//builder.append("PartTime [timePay=");
		builder.append(super.toString());
		builder.append(timePay);
		//builder.append("]");
		return builder.toString();
	}

	@Override
	void message() {
		System.out.println(super.geteName()+"사원은 비정규직입니다.");
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	
	
	
	
	

}
