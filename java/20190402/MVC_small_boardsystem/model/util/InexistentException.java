package gsitm.exam.model.util;
/**
 *   1) 체크 :  Exception
 *   2) 비체크 : RuntimeException
 * */
public class InexistentException extends Exception {
	public InexistentException() {}
	public InexistentException(String message) {
		super(message);
	}
	
}
