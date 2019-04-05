package ex0403.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	public ClientChatExam() {
		try {
			Socket sk = new Socket("127.0.0.1", 8000);
			
			
			//보내는 스레드
			new SendThread(sk, "클라이언트가 보내온 내용").start();
			
			//받는 스레드
			new Thread() {
				public void run() {
					BufferedReader br = null;
					try {
						br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
						
						while(true) {
							String msg = br.readLine();
							if(msg.equals("exit"))break;
							System.out.println(msg);
						}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							System.out.println("Client 받는 스레드 종료");
							br.close();
							System.exit(0);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
	

	public static void main(String[] args) {
		new ClientChatExam();

	}

}
