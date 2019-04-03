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
				System.out.println("Client접속 대기중입니다.");
				 Socket sk = server.accept(); //클라이언트 접속을 기다린다.
				 
				 System.out.println(sk.getInetAddress()+"님 접속하셨습니다."); // 누가 접속하였느냐
				 
				 BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream())); // 바이트 단위 읽기를 문자단위 읽기로 변환해준다!
				 
				 String clientMsg = br.readLine();
				 System.out.println("클라이언트가 보내온 내용 : "+clientMsg);
				 
				 //클라이언트에게 데이터 보내기
				 PrintWriter pr = new PrintWriter(sk.getOutputStream(), true);
				 pr.println("피들스틱은 끼룩끼룩~~");
				 
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
