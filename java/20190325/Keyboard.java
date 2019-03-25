package ex0325;

import java.util.Scanner;

public class Keyboard {

	
	public static void keyboardInput(int a, int b, String s){
		double c = a;
		double d = b;
		System.out.println(s);
		if (s.equals("+"))
			System.out.println("계산 결과 : "+(c+d));
		else if (s.equals("-"))
			System.out.println("계산 결과 : "+(c-d));
		else if (s.equals("/")&&b==0)
			System.out.println("계산할 수 없습니다.");
		else if (s.equals("/"))
			System.out.println("계산 결과 : "+(c/d));
		else if (s.equals("*"))
			System.out.println("계산 결과 : "+(c*d));
		else if (s.equals("%"))
			System.out.println("계산 결과 : "+(c%d));
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		String c = scn.next();
		System.out.println(c);
		keyboardInput(a,b,c);
		
		//String는 object이기 때문에 ==연산자를 쓰게 되면 주소값을 비교하게 되므로 무조건 false가 나오게 된다!
	}
	

}
