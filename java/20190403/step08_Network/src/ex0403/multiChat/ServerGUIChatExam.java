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
				System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�...");
				sk=server.accept();
				System.out.println(sk.getInetAddress()+"�� ���� �ϼ̽��ϴ�...");
				ServerThread th = new ServerThread();
				th.start();
				list.add(th);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * ������ Ŭ���̾�Ʈ�� socket�� ������� ������ �ִ� thread
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
				
				//��ȭ�� �ޱ�
				name = br.readLine();
				
				//��ȭ���� ��� Ŭ���̾�Ʈ���� ������
				sendMessage("["+name+"]�� �����ϼ̽��ϴ�.");
				
				String msg=null;
				while((msg=br.readLine())!=null) {
					sendMessage("["+name+"] "+msg);
				}
				
			} catch (Exception e) {
				//���� thread�� list���� �����Ѵ�.
				list.remove(this);
				//���� Ŭ���̾�Ʈ�鿡�� �˸���.
				sendMessage("["+name+"] ���� �����Ͽ����ϴ�.");
				//���� â�� �˸���.
				System.out.println(ip+"�� "+"["+name+"] ���� �����ϼ̽��ϴ�.");
				e.printStackTrace();
			}
		}
	}//������ ��
	
	
	/*
	 * list�ȿ� �ִ� ��� Ŭ���̾�Ʈ���� �޽��� �����ϱ� ���
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
