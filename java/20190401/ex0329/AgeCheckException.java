package ex0329;


/*
 * ���ڰ� 18���� ������ �߻��ϴ� ���� Ŭ����! ����� ���� exception
 */
//public class AgeCheckException extends RunTimeException{ //exception�� runtime���� �ٲٸ�????
public class AgeCheckException extends Exception{ 
	static int cnt=0;
	public AgeCheckException() {}
	public AgeCheckException(String msg) {
		super(msg);
		//�ٽ� �����
		cnt++;
	}

	
}
