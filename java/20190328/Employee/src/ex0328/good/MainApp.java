package ex0328.good;




public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee [] emp = new Employee[5];
		
		/*
		 * 1. 다형성 차원의 피드백
		 * 다형성과 상속을 통해 데이터 패턴의 중복을 피할 수 있었다. 비슷한 성격의 오브젝트를 묶어서 한눈에 관리 할 수 있었으며,
		 * 각 오브젝트별로 특색있는 속성만을 뽑아서 따로 관리를 할 수 있었다.
		 * 
		 * 또한 비슷한 성격을 묶는 방법을 통해 아래와 같이 통합적으로 관리 할 수 있었다.
		 */
		
		emp[0] = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
		emp[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
		emp[2] = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
		
		emp[3] = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
		emp[4] = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);
		
		System.out.println("Employee Info");
		for(int i=0;i<emp.length;i++)
			System.out.println(emp[i].toString());

		System.out.println();
		System.out.println("Employee Message");
		for(int i=0;i<emp.length;i++)
			emp[i].message();
		
		
		
	}

}






