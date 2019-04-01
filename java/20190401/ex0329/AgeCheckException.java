package ex0329;


/*
 * 숫자가 18보다 작으면 발생하는 예외 클래스! 사용자 정의 exception
 */
//public class AgeCheckException extends RunTimeException{ //exception을 runtime으로 바꾸면????
public class AgeCheckException extends Exception{ 
	static int cnt=0;
	public AgeCheckException() {}
	public AgeCheckException(String msg) {
		super(msg);
		//다시 물어보자
		cnt++;
	}

	
}
