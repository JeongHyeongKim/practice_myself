package ex0403.multiChat;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerGUIChatExam {

	ServerSocket server;
	Socket sk;
	List<ServerThread> list = new ArrayList<>();
	public ServerGUIChatExam() {
		try {
			server = new ServerSocket(8000);
			while(true) {
				System.out.println("클라이언트의 접속을 기다리고 있습니다...");
				sk=server.accept();
				System.out.println(sk.getInetAddress()+"님 접속 하셨습니다...");
				ServerThread th = new ServerThread();
				th.start();
				list.add(th);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 접속한 클라이언트의 socket를 스레드로 관리해 주는 thread
		 */
		
		
	}
	
	
	class ServerThread extends Thread{
		BufferedReader br;
		PrintWriter pw;
		String name;
		String ip;
		
		public void run() {
			
			try {
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				pw = new PrintWriter(sk.getOutputStream(),true);
				
				ip = sk.getInetAddress().toString();
				
				//대화명 받기
				name = br.readLine();
				
				//대화명을 모든 클라이언트에게 보내기
				sendMessage("["+name+"]님 입장하셨습니다.");
				
				String msg=null;
				while((msg=br.readLine())!=null) {
					sendMessage("["+name+"] "+msg);
				}
				
			} catch (Exception e) {
				//현재 thread를 list에서 제거한다.
				list.remove(this);
				//남은 클라이언트들에게 알린다.
				sendMessage("["+name+"] 님이 퇴장하였습니다.");
				//서버 창에 알린다.
				System.out.println(ip+"의 "+"["+name+"] 님이 퇴장하셨습니다.");
				e.printStackTrace();
			}
		}
	}//쓰레드 끝
	
	
	/*
	 * list안에 있는 모든 클라이언트에게 메시지 전송하기 기능
	 */
	public void sendMessage(String msg) {
		for(ServerThread st:list) {
			st.pw.println(msg);
		}
	}
	////////////////////////////////////////////
	public static void main(String[] args) {
		new ServerGUIChatExam();

	}

}
