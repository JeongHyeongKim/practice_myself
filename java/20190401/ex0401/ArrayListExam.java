package ex0401;
import java.util.ArrayList;



class Test{
	int a=100;
	public void aa() {}

}

//////////////////////////////////////////////////////////////////

//메모리 관점에서의 설명이 필요합니다.
class ArrayListExam extends ArrayList{

	//전역 Variable
	//Object 타입1개, int 타입 1개;
	//Array list의 기본 크기는 10개임.
	Object object;
	int buf;
	
	//Constractor
	public ArrayListExam(){
		super(5);	
	}

	//method
	//method이름			리턴타입		인수						
	
	/*addInt				없음			정수(int)1개				
	하는일 : 인수로 받은 정수를 객체로 만들어 list에 추가.*/
	public void addInt(int i) {
		Integer integer = new Integer(i);
		add(integer);
	}
		
	
	
	/*addFloat				없음			실수(float)1개			
		하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.*/
	public void addFloat(float f) {
		Float ff = new Float(f);
		add(ff);
	}
	
	
	/*addString			없음			String 문자열1개		
		하는일 : 인수로 받은 String 을 list에 추가.*/
	public void addString(String s) {
		String ss = new String(s);
		Test t = new Test();
		
		add(ss);
		add(t);
	}
	
	
	
	/*printList		없음			없음			
		정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후 전역변수 출력.
		List에 저장된 각 객체를 맴버변수에 저장한후 출력*/
	public void printList() {
		this.buf = super.size();
		System.out.println("ArrayList Size : "+buf);
		for(int i=0;i<buf;i++) {
			object = super.get(i);
			System.out.println(this.get(i)+" "+object);
			
			
		}
		System.out.println("-------------------------");
		object=super.get(3);
	}
		
		

	public static void main(String args[]){
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");
		
		list.addInt(5);
		
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
	}
}

/*실행결과

list에 들어있는 객체의 총 개수는=3
5
5.5
newString

Normal Termination
출력 완료 (0초 경과).
*/