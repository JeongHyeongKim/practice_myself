package ex0403.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 클라이언트와 1:1채팅을 위한 서버 클래스
 */
public class ServerChatExam {
	public ServerChatExam() {
		try {
			ServerSocket server = new ServerSocket(8000);
			System.out.println("클라이언트 접속 대기중");
			Socket sk = server.accept();
			System.out.println(sk.getInetAddress()+"님 입장하셨습니다.");
			
			//보내기 스레드
			new SendThread(sk,"서버가 보내온 내용").start();
			
			//받는 스레드
			new Thread() {
				public void run() {
					BufferedReader br = null;
					try {
						br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
						
						while(true) {
							String msg = br.readLine();
							if(msg==null) break;
							System.out.println(msg);
						}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							System.out.println("Server 받는 스레드 종료");
							br.close();
							server.close();
							System.exit(0);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerChatExam();

	}

}
