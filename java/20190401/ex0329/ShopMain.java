package ex0329;

import java.util.Random;

public class ShopMain {

	public static void main(String[] args)  {
		//������ �ٷ�� Ŭ������ ���� ����!
		Random r = new Random();
		Shoping shoping = new Shoping();
		
		for(int i=0;i<10;i++) {
			int age=r.nextInt(55)+1; // 0~54
			try {
				System.out.println("�մ��� ���̴� "+age+"�� �Դϴ�");
				shoping.shop(age);
			} catch(AgeCheckException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
			System.out.println("Total Exception called cnt : "+AgeCheckException.cnt);
		}

	}

}
