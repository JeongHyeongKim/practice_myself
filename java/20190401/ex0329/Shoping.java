package ex0329;

public class Shoping {
	
	
	public void shop(int age) throws AgeCheckException{
		if(age>18) {
			System.out.println(age+"室 脊艦陥. ぞしぞしぞしぞしぞし");
		}else {
			throw new AgeCheckException("亜虞 績原");
		}

	}
}
