package ex0403;

public class DaemonThreadExam {

	public static void main(String[] args) {
		System.out.println("start of main");
		
		Thread th = new Thread() {
			public void run() {
				while(true) {
					System.out.println("나는 데몬스레드");
				}
			}
		};
		th.setDaemon(true);
		th.start();
		
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end of main");

	}

}