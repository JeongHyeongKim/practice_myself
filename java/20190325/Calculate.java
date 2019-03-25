package ex0325;

public class Calculate {
	private int total(int kor, int eng, int mat) {
		return kor+eng+mat;
	}
	
	private double avg(int total, int cnt) {
		double total_convert = total*1.0;
		double buf = total/cnt;
		//System.out.println("평균 : "+buf);
		return buf;
	}
	private String setGrade(double avg) {
		int params;
		String buf = null;
		if(avg>89)
			params=1;
		else if (avg>79 && avg<90)
			params=2;
		else if (avg>69 && avg<80)
			params=3;
		else if (avg>59 && avg<70)
			params=4;
		else 
			params=5;
		//System.out.println(params);
		switch (params) {
		case 1:
			buf="수";
			break;
		case 2:
			buf= "우";
			break;
		case 3:
			buf= "미";
			break;
		case 4:
			buf= "양";
			break;
		case 5:
			buf= "가";
			break;
		}
		return buf;
	}
	
	public static void main(String []args){
		
		Calculate cal = new Calculate();
		int total = cal.total((int) (Math.random()*56)+45,(int) (Math.random()*56)+45,(int) (Math.random()*56)+45);
		double avg =cal.avg(total,3);
		String grade = cal.setGrade(avg);
		System.out.println("평균점수 : "+ avg);
		System.out.println("등급 : "+ grade);
		
		
	}//end of main

	
}
