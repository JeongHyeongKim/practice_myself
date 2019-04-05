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
		super("ClientGUIChatExam �Դϴ�.");
		
		
		//�ɼ� ����
		textArea.setFocusable(false); //�ؽ�Ʈ ���� �۾� �������� Ű���� Ŀ���� �ö��� ���Ѵ�.
		textArea.setBackground(Color.green);
		
		text.requestFocus(); // �Է�â�� Ŀ�� ����
		
		Container con = super.getContentPane();
		con.add(jsp, BorderLayout.CENTER);
		con.add(text, BorderLayout.SOUTH);
		
		setSize(500,400);
		setLocationRelativeTo(null); //�� �߾ӿ� ���Դϴ�.
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�ݱ� Ŭ���ϸ� â�� ����.
		
		this.connection();
		
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// text�ڽ��� ���� �������� �����Ѵ�.
				pw.println(text.getText());
				
				text.setText("");//�ؽ�Ʈ�ڽ� ����
				
			}
		});
		
	}

	
	public void connection() {
		try {
			sk = new Socket("192.168.9.211", 8000);
			pw = new PrintWriter(sk.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			
			//��ȭ�� �Է��ϱ�
			String name = JOptionPane.showInputDialog("��ȭ���� �Է����ּ���");
			pw.println(name); // �������� ��ȭ�� ����!!!!!
			
			new ReceiveThread().start();
			super.setTitle(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * ������ �������� �����͸� �޾Ƽ� textArea ���� �߰��Ѵ�.
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
