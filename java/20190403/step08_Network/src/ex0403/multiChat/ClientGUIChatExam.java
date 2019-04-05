package ex0403.multiChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUIChatExam extends JFrame {
	
	JTextArea textArea = new JTextArea();
	JScrollPane jsp = new JScrollPane(textArea);
	JTextField text = new JTextField();
	
	Socket sk;
	PrintWriter pw;
	BufferedReader br;
	
	
	public ClientGUIChatExam() {
		super("ClientGUIChatExam 입니다.");
		
		
		//옵션 설정
		textArea.setFocusable(false); //텍스트 에어리어에 글씨 못스도록 키보드 커서가 올라가지 못한다.
		textArea.setBackground(Color.green);
		
		text.requestFocus(); // 입력창에 커서 놓기
		
		Container con = super.getContentPane();
		con.add(jsp, BorderLayout.CENTER);
		con.add(text, BorderLayout.SOUTH);
		
		setSize(500,400);
		setLocationRelativeTo(null); //정 중앙에 놓입니다.
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 클릭하면 창이 닫힘.
		
		this.connection();
		
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// text박스의 값을 서버에게 전송한다.
				pw.println(text.getText());
				
				text.setText("");//텍스트박스 리셋
				
			}
		});
		
	}

	
	public void connection() {
		try {
			sk = new Socket("192.168.9.211", 8000);
			pw = new PrintWriter(sk.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			
			//대화명 입력하기
			String name = JOptionPane.showInputDialog("대화명을 입력해주세요");
			pw.println(name); // 서버에게 대화명 전송!!!!!
			
			new ReceiveThread().start();
			super.setTitle(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 서버가 보내오는 데이터를 받아서 textArea 위에 추가한다.
	 */
	class ReceiveThread extends Thread{
		public void run() {
			
			try {
				String msg=null;
				while((msg=br.readLine())!=null) {
					textArea.append(msg+"\n");
					textArea.setCaretPosition(textArea.getText().length());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ClientGUIChatExam();
	}

}
