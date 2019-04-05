package ex0403.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Ŭ���̾�Ʈ �Ǵ� ������ Ű���� �Է��� �޾Ƽ� �����͸� ������� ������ ������
 */
public class SendThread extends Thread {
	
	Socket sk;
	String name;
	
	public SendThread(Socket sk, String name) {
		this.sk=sk;
		this.name=name;
	}

	@Override
	public void run() {
		
		
		Scanner sc = new Scanner(System.in); // Ű���� �Է� �غ�
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(sk.getOutputStream(),true);
			while(true) {
				String msg = sc.nextLine();
				if(msg.equals("exit")) {
					pw.println(msg);
					break;
				}
				pw.println("["+name+"] : "+msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(name+"�� ���� �߻�!");
		} finally {
			pw.close();
			try {
				sk.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(name+"�� close ���� �߻�!");
			}
		}
		super.run();
	}
}
