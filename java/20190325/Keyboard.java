package ex0325;

import java.util.Scanner;

public class Keyboard {

	
	public static void keyboardInput(int a, int b, String s){
		double c = a;
		double d = b;
		System.out.println(s);
		if (s.equals("+"))
			System.out.println("��� ��� : "+(c+d));
		else if (s.equals("-"))
			System.out.println("��� ��� : "+(c-d));
		else if (s.equals("/")&&b==0)
			System.out.println("����� �� �����ϴ�.");
		else if (s.equals("/"))
			System.out.println("��� ��� : "+(c/d));
		else if (s.equals("*"))
			System.out.println("��� ��� : "+(c*d));
		else if (s.equals("%"))
			System.out.println("��� ��� : "+(c%d));
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		String c = scn.next();
		System.out.println(c);
		keyboardInput(a,b,c);
		
		//String�� object�̱� ������ ==�����ڸ� ���� �Ǹ� �ּҰ��� ���ϰ� �ǹǷ� ������ false�� ������ �ȴ�!
	}
	

}
