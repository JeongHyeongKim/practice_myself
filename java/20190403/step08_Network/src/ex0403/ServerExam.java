package ex0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	public ServerExam() {
		try (ServerSocket server = new ServerSocket(8000)){
			while(true) {
				System.out.println("Client���� ������Դϴ�.");
				 Socket sk = server.accept(); //Ŭ���̾�Ʈ ������ ��ٸ���.
				 
				 System.out.println(sk.getInetAddress()+"�� �����ϼ̽��ϴ�."); // ���� �����Ͽ�����
				 
				 BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream())); // ����Ʈ ���� �б⸦ ���ڴ��� �б�� ��ȯ���ش�!
				 
				 String clientMsg = br.readLine();
				 System.out.println("Ŭ���̾�Ʈ�� ������ ���� : "+clientMsg);
				 
				 //Ŭ���̾�Ʈ���� ������ ������
				 PrintWriter pr = new PrintWriter(sk.getOutputStream(), true);
				 pr.println("�ǵ齺ƽ�� ���賢��~~");
				 
				 sk.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerExam();

	}

}
