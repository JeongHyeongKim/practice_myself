package ex0403.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientChatExam {
	public ClientChatExam() {
		try {
			Socket sk = new Socket("", 8000);
			
			
			//보내는 스레드
			new SendThread(sk, "클라이언트가 보내온 내용").start();
			
			//받는 스레드
			new Thread() {
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
						
						while(true) {
							String msg = br.readLine();
							if(msg==null) break;
							System.out.println();
						}
					} catch (IOException e) {
						e.printStackTrace();
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
