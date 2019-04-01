package ex0329;

public class Shoping {
	
	
	public void shop(int age) throws AgeCheckException{
		if(age>18) {
			System.out.println(age+"세 입니다. ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇ");
		}else {
			throw new AgeCheckException("가라 임마");
		}

	}
}
