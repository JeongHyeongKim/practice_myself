package ex0403.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
<<<<<<< HEAD
=======
import java.net.UnknownHostException;
>>>>>>> 2ed018e293ed90025adaa93aa37e7d632ca2780c

public class ClientChatExam {
	public ClientChatExam() {
		try {
<<<<<<< HEAD
			Socket sk = new Socket("127.0.0.1", 8000);
=======
			Socket sk = new Socket("", 8000);
>>>>>>> 2ed018e293ed90025adaa93aa37e7d632ca2780c
			
			
			//보내는 스레드
			new SendThread(sk, "클라이언트가 보내온 내용").start();
			
			//받는 스레드
			new Thread() {
				public void run() {
<<<<<<< HEAD
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
=======
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
						
						while(true) {
							String msg = br.readLine();
							if(msg==null) break;
							System.out.println();
						}
					} catch (IOException e) {
						e.printStackTrace();
>>>>>>> 2ed018e293ed90025adaa93aa37e7d632ca2780c
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
