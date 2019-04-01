package ex0401;
import java.util.ArrayList;



class Test{
	int a=100;
	public void aa() {}

}

//////////////////////////////////////////////////////////////////

//�޸� ���������� ������ �ʿ��մϴ�.
class ArrayListExam extends ArrayList{

	//���� Variable
	//Object Ÿ��1��, int Ÿ�� 1��;
	//Array list�� �⺻ ũ��� 10����.
	Object object;
	int buf;
	
	//Constractor
	public ArrayListExam(){
		super(5);	
	}

	//method
	//method�̸�			����Ÿ��		�μ�						
	
	/*addInt				����			����(int)1��				
	�ϴ��� : �μ��� ���� ������ ��ü�� ����� list�� �߰�.*/
	public void addInt(int i) {
		Integer integer = new Integer(i);
		add(integer);
	}
		
	
	
	/*addFloat				����			�Ǽ�(float)1��			
		�ϴ��� : �μ��� ���� �Ǽ��� ��ü�� ����� list�� �߰�.*/
	public void addFloat(float f) {
		Float ff = new Float(f);
		add(ff);
	}
	
	
	/*addString			����			String ���ڿ�1��		
		�ϴ��� : �μ��� ���� String �� list�� �߰�.*/
	public void addString(String s) {
		String ss = new String(s);
		Test t = new Test();
		
		add(ss);
		add(t);
	}
	
	
	
	/*printList		����			����			
		������ ���������� ���� list�� ����ִ� ��ü�� ���� �Է��� �� �������� ���.
		List�� ����� �� ��ü�� �ɹ������� �������� ���*/
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

/*������

list�� ����ִ� ��ü�� �� ������=3
5
5.5
newString

Normal Termination
��� �Ϸ� (0�� ���).
*/