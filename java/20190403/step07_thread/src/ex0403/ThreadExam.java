package ex0403;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("start of main");
		
		NumberThread th1 = new NumberThread("첫번째 쓰레드");
		NumberThread th2 = new NumberThread("두번째 쓰레드");
		
		AlphaThread at = new AlphaThread();
		Thread th3 = new Thread(at, "세번째 쓰레드");
		
		/*th1.run();
		th2.run();
		th3.run();*/
		
		th1.start();
		th2.start();
		th3.start();
		
		//특정한 쓰레드가 일을 끝날때 까지 이하의 문장 실행 못함
		/*try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println("총 합계 : "+th1.sum);
		System.out.println("end of main");

	}

}

//////////////////////////////////////////////////////


/**
1~100까지 출력하는 쓰레드
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
				Thread.sleep(100); // 0.1초 대기
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Thread.yield(); // 양보
		}
		System.out.println(th.getName()+" end~~~~~~~~~~~~~");
	}
}

class AlphaThread implements Runnable{
	public void run() {
		//현재 실행중인 쓰레드 객체를 구한다.
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