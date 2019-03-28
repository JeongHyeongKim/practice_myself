package ex0328.good;




public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee [] emp = new Employee[5];
		
		/*
		 * 1. ������ ������ �ǵ��
		 * �������� ����� ���� ������ ������ �ߺ��� ���� �� �־���. ����� ������ ������Ʈ�� ��� �Ѵ��� ���� �� �� �־�����,
		 * �� ������Ʈ���� Ư���ִ� �Ӽ����� �̾Ƽ� ���� ������ �� �� �־���.
		 * 
		 * ���� ����� ������ ���� ����� ���� �Ʒ��� ���� ���������� ���� �� �� �־���.
		 */
		
		emp[0] = new FullTime(10, "���缮", "���׿��", 0 , "2013-05-01", "���ѵ���",8500,200);
		emp[1] = new FullTime(20, "�ڸ��", "����",10, "2013-06-20", "���ѵ���",7500,100);
		emp[2] = new FullTime(30, "������", "������",10 , "2013-06-22", "���ѵ���",6000,0);
		
		emp[3] = new PartTime(40, "��ȫö", "������",20 , "2014-05-01", "���ѵ���",20000);
		emp[4] = new PartTime(50, "����", "����",30 , "2014-05-02", "���ѵ���",25000);
		
		System.out.println("Employee Info");
		for(int i=0;i<emp.length;i++)
			System.out.println(emp[i].toString());

		System.out.println();
		System.out.println("Employee Message");
		for(int i=0;i<emp.length;i++)
			emp[i].message();
		
		
		
	}

}






