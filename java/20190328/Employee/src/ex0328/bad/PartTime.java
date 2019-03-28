package ex0328.bad;

public class PartTime {
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int timePay;
	
	public PartTime() {
		System.out.println("Parttime Info");
		System.out.println(toString());
	}
	public PartTime(int empNo, String eName, String job, int mgr,String hiredate, String deptName, int timePay) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.timePay = timePay;
	}
	public int getEmpNo() {
		return empNo;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getTimePay() {
		return timePay;
	}
	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//builder.append("PartTime [empNo=");
		
		builder.append(empNo + "|");
		//builder.append(", eName=");
		builder.append(eName + "|");
		//builder.append(", job=");
		builder.append(job + "|");
		//builder.append(", hiredate=");
		builder.append(hiredate + "|");
		//builder.append(", deptName=");
		builder.append(deptName + "|");
		//builder.append(", timePay=");
		builder.append(timePay + "|");
		//builder.append("]");
		return builder.toString();
	}
	
	
	public void msg() {
		System.out.println(eName+"사원은 비정규직입니다.");
	}
	

}
