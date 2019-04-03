package ex0403;

public class SynchronizedExam {
	
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		CustomerThread t1 = new CustomerThread(bank, "������", true);
		CustomerThread t2 = new CustomerThread(bank, "�Һ���", false);
		
		t1.start();
		t2.start();
	}

}


/////////////////////////////////////////////////////////

/**
 * ���� �����尡 �����ϰ� �� ��ü
 */
class Bank {
	int balance; // 0
	/*
	 * synchronized�� Ư���� �������� synchronized ���� ������ ��ĥ �������� ������� ������ �� ����.
	 * 
	 * wait, notify,notifyAll�޼ҵ�� �ݵ�� synchronized�� �ȿ����� ��밡����
	 */
	public synchronized void balanceChange(String name, boolean state) {
		if(state) {
			if(balance<=0) {
				/*synchronized(this) {*/
				System.out.print(name+" ==> ���� �� : "+balance+", ");
				balance++;
				System.out.println(name+" ==> ������ �� : "+balance);//}
			}else {
				try {
					System.out.println(name+" ��� ���!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}else {
			if(balance>=1) {
				/*synchronized(this) {*/
				System.out.print(name+" ==> ���� �� : "+balance+", ");
				balance--;
				System.out.println(name+" ==> ������ �� : "+balance);//}
			}else {
				try {
					System.out.println(name+" ��� ���!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		notifyAll(); // wait�� ���� ������� �����带 �����.
	}//end of method
}//bank end

////////////////////////////////////////////////////////////////
/*
 * �� ������ ���� ������ �ۼ�
 */
class CustomerThread extends Thread{
	Bank bank = new Bank();
	String name;
	boolean state;
	
	public CustomerThread(Bank bank, String name, boolean state) {
		super(name); //������ �̸��� ������ݴϴ�
		this.bank=bank;
		this.name=name;
		this.state=state;
	}
	public void run() {
		for(int i=0;i<50;i++) {
			bank.balanceChange(name, state);
		}
		System.out.println(super.getName()+"������ End~~~~~~~~~~");
	}
}



