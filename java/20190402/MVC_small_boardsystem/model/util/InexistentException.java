package gsitm.exam.model.util;
/**
 *   1) üũ :  Exception
 *   2) ��üũ : RuntimeException
 * */
public class InexistentException extends Exception {
	public InexistentException() {}
	public InexistentException(String message) {
		super(message);
	}
	
}
