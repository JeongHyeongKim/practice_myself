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
<<<<<<< HEAD
					BufferedReader br = null;
					try {
						br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
=======
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
>>>>>>> 2ed018e293ed90025adaa93aa37e7d632ca2780c
						
						while(true) {
							String msg = br.readLine();
							if(msg==null) break;
<<<<<<< HEAD
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
=======
							System.out.println();
						}
					} catch (IOException e) {
						e.printStackTrace();
>>>>>>> 2ed018e293ed90025adaa93aa37e7d632ca2780c
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
