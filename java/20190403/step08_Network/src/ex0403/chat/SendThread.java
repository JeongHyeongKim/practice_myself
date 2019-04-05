package ex0403.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * 클라이언트 또는 서버가 키보드 입력을 받아서 데이터를 상대측에 보내는 스레드
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
		
		
		Scanner sc = new Scanner(System.in); // 키보드 입력 준비
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
			System.out.println(name+"의 오류 발생!");
		} finally {
			pw.close();
			try {
				sk.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(name+"의 close 오류 발생!");
			}
		}
		super.run();
	}
}
