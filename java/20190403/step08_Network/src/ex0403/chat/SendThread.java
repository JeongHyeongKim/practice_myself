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
		
		try {
			PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
			while(true) {
				String msg = sc.nextLine();
				if(msg.equals("exit")) break;
				pw.println("["+name+"] : "+msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.run();
	}
}
