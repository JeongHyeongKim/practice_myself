package ex0403.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	public ClientChatExam() {
		try {
			Socket sk = new Socket("127.0.0.1", 8000);
			
			
			//������ ������
			new SendThread(sk, "Ŭ���̾�Ʈ�� ������ ����").start();
			
			//�޴� ������
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
							System.out.println("Client �޴� ������ ����");
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
