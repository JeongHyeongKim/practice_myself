package ex0329;

public class Shoping {
	
	
	public void shop(int age) throws AgeCheckException{
		if(age>18) {
			System.out.println(age+"�� �Դϴ�. ��������������������");
		}else {
			throw new AgeCheckException("���� �Ӹ�");
		}

	}
}
