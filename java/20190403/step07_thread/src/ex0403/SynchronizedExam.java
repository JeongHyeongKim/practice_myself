package ex0403;

public class SynchronizedExam {
	
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		CustomerThread t1 = new CustomerThread(bank, "생산자", true);
		CustomerThread t2 = new CustomerThread(bank, "소비자", false);
		
		t1.start();
		t2.start();
	}

}


/////////////////////////////////////////////////////////

/**
 * 여러 스레드가 공유하게 될 객체
 */
class Bank {
	int balance; // 0
	/*
	 * synchronized는 특정한 스레드의 synchronized 블럭의 실행을 마칠 때까지는 제어권을 가져갈 수 없다.
	 * 
	 * wait, notify,notifyAll메소드는 반드시 synchronized블럭 안에서만 사용가능함
	 */
	public synchronized void balanceChange(String name, boolean state) {
		if(state) {
			if(balance<=0) {
				/*synchronized(this) {*/
				System.out.print(name+" ==> 현재 값 : "+balance+", ");
				balance++;
				System.out.println(name+" ==> 증가한 값 : "+balance);//}
			}else {
				try {
					System.out.println(name+" 대기 모드!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}else {
			if(balance>=1) {
				/*synchronized(this) {*/
				System.out.print(name+" ==> 현재 값 : "+balance+", ");
				balance--;
				System.out.println(name+" ==> 감소한 값 : "+balance);//}
			}else {
				try {
					System.out.println(name+" 대기 모드!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		notifyAll(); // wait에 의해 대기중인 스레드를 깨운다.
	}//end of method
}//bank end

////////////////////////////////////////////////////////////////
/*
 * 고객 관리를 위한 스레드 작성
 */
class CustomerThread extends Thread{
	Bank bank = new Bank();
	String name;
	boolean state;
	
	public CustomerThread(Bank bank, String name, boolean state) {
		super(name); //스레드 이름을 만들어줍니다
		this.bank=bank;
		this.name=name;
		this.state=state;
	}
	public void run() {
		for(int i=0;i<50;i++) {
			bank.balanceChange(name, state);
		}
		System.out.println(super.getName()+"쓰레드 End~~~~~~~~~~");
	}
}



