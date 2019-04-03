package ex0403;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("start of main");
		
		NumberThread th1 = new NumberThread("ù��° ������");
		NumberThread th2 = new NumberThread("�ι�° ������");
		
		AlphaThread at = new AlphaThread();
		Thread th3 = new Thread(at, "����° ������");
		
		/*th1.run();
		th2.run();
		th3.run();*/
		
		th1.start();
		th2.start();
		th3.start();
		
		//Ư���� �����尡 ���� ������ ���� ������ ���� ���� ����
		/*try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println("�� �հ� : "+th1.sum);
		System.out.println("end of main");

	}

}

//////////////////////////////////////////////////////


/**
1~100���� ����ϴ� ������
**/
class NumberThread extends Thread{
	int sum;
	
	public NumberThread(String name) {
		super(name);
	}
	public void run() {
		Thread th = Thread.currentThread();
		for(int i=1;i<100;i++) {
			System.out.println(th.getName()+"==>"+i+", super.getPriority() : "+super.getPriority());
			sum+=i;
			/*try {
				Thread.sleep(100); // 0.1�� ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Thread.yield(); // �纸
		}
		System.out.println(th.getName()+" end~~~~~~~~~~~~~");
	}
}

class AlphaThread implements Runnable{
	public void run() {
		//���� �������� ������ ��ü�� ���Ѵ�.
		Thread th = Thread.currentThread();
		for(char ch='A';ch<='z';ch++) {
			System.out.println(th.getName()+"==_>"+ch+", th.getPriority() : "+th.getPriority());
			/*try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Thread.yield();
		}
		System.out.println(th.getName()+" end~~~~~~~~~~~~~");
		
	}
}