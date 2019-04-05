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
			//연결했으면 데이터를 보내보자
			
			PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
<<<<<<< HEAD
			pw.println("gdgd");
=======
			pw.println("");
>>>>>>> 2ed018e293ed90025adaa93aa37e7d632ca2780c
			
			//서버가 보내오는 내용을 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String serverMsg = br.readLine();
			System.out.println("서버가 보낸 내용 : "+serverMsg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientExam();

	}

}
