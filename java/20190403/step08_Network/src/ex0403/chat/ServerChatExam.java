package ex0403.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Ŭ���̾�Ʈ�� 1:1ä���� ���� ���� Ŭ����
 */
public class ServerChatExam {
	public ServerChatExam() {
		try {
			ServerSocket server = new ServerSocket(8000);
			System.out.println("Ŭ���̾�Ʈ ���� �����");
			Socket sk = server.accept();
			System.out.println(sk.getInetAddress()+"�� �����ϼ̽��ϴ�.");
			
			//������ ������
			new SendThread(sk,"������ ������ ����").start();
			
			//�޴� ������
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
							System.out.println("Server �޴� ������ ����");
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
