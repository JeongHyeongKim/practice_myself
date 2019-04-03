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
			
			
			//������ ������
			new SendThread(sk, "Ŭ���̾�Ʈ�� ������ ����").start();
			
			//�޴� ������
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
