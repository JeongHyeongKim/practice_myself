package ex0403;

public class InterruptedExam {

	public static void main(String[] args) {
		System.err.println("���� ����");
		
/*		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
					
					try {
						while(true) {
						System.out.println("������ �������");
						Thread.sleep(100);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					}
				
				
			
		});
			
		th.start();
		*/
		
		Thread th = new Thread() {
			@Override
			public void run() {
				while(true) {
					System.out.println("Thread��  ������ ���߱�...");
					if(interrupted())
						break;
				}
			}
		};
		
		th.start();
		
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		th.interrupt();
		System.out.println("���� ����");
	}

}











