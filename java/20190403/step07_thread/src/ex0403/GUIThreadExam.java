package ex0403;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIThreadExam extends JFrame implements Runnable{

	JTextField text1 = new JTextField(10);
	JTextField text2 = new JTextField(10);
	JButton btn = new JButton("Start");
	
	public GUIThreadExam() {
		
		super.setLayout(new FlowLayout());
		
		Container con = super.getContentPane();
		con.add(text1);
		con.add(text2);
		con.add(btn);
		
		setSize(500,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�̺�Ʈ��� -> ����Ʈ�߻���ü.addXXListener
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AlphaThread().start();
			}
		});
		DecimalThread dt = new DecimalThread(text1);
		dt.start();
	}
	
	/*
	 * ��ư�� Ŭ�� ���� �� A-z���� textField�� ����ϱ�
	 */
	
	class AlphaThread extends Thread{ //inner class
		public void run() {
			for(char ch='A';ch<'z';ch++) {
				text2.setText(ch+"");
				try {
					Thread.sleep(200);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		GUIThreadExam te = new GUIThreadExam();
		Thread th = new Thread(te);
		th.start();
		
		//DecimalThread dt = new DecimalThread(text);

	}
	
	@Override
	//Ÿ��Ʋ���� �ð谡 �����Ѵ�.
	public void run() {
		while(true) {
			
			
			try {
				Calendar now = Calendar.getInstance();
				int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH)+1;
				int date = now.get(Calendar.DATE);
				int hour = now.get(Calendar.HOUR_OF_DAY);
				int min = now.get(Calendar.MINUTE);
				int sec = now.get(Calendar.SECOND);
				
				StringBuilder sb = new StringBuilder();
				sb.append(year+"�� ");
				sb.append(month+"�� ");
				sb.append(date+"�� ");
				sb.append(hour+"�� ");
				sb.append(min+"�� ");
				sb.append(sec+"�� ");
				
				super.setTitle(sb.toString());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}


class DecimalThread extends Thread{
	JTextField text;
	
	public DecimalThread(JTextField text) {
		this.text = text;
	}
	public void run() {
		for(int i=1;i<1001;i++) {
			text.setText(i+"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}




