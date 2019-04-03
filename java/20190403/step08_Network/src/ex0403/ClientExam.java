package ex0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExam {
	public ClientExam() {
		try {
			Socket sk = new Socket("192.168.9.250", 8000);
			//���������� �����͸� ��������
			
			PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
			pw.println("");
			
			//������ �������� ������ �б�
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String serverMsg = br.readLine();
			System.out.println("������ ���� ���� : "+serverMsg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientExam();

	}

}
