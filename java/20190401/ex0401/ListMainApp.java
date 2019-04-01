package ex0401;

import java.util.ArrayList;
import java.util.List;

public class ListMainApp {
	
	List<Student> list = new ArrayList<>(5); //�ʵ带 �̿��� ������
	/*
	 * List�� ������ �߰�
	 */
	
	public void addList(Student s) {
		list.add(s);
	}
	/*
	 * List�� �ִ� ��� ������ ���
	 */
	public void printList() {
		System.out.println("List Size : "+list.size());
		System.out.println("---------- Student List ----------");
		for(Student s:list) {
			System.out.println(s);
		}
	}
	
	/*
	 * ���� ã�� (�˻�)
	 */

	public void searchByName(String name) {
		for(Student s : list) {
			if(s.getName().equals(name)) {
				System.out.println(s);
				return; // return void �� ���� �����ΰ�?????
			}
		}
		System.out.println(name+"��(��) ����..");
	}
	
	
	public static void main(String[] args) {
		ListMainApp listMainApp = new ListMainApp();
		listMainApp.addList(new Student("���ű�",10,"����"));
		listMainApp.addList(new Student("���ű�1",20,"����1"));
		listMainApp.addList(new Student("���ű�2",30,"����2"));
		listMainApp.addList(new Student("���ű�3",40,"����3"));
		listMainApp.addList(new Student("���ű�4",50,"����4"));
		listMainApp.addList(new Student("���ű�5",60,"����5"));
		
		listMainApp.printList();
		System.out.println("--------------------------------------------");
		listMainApp.searchByName("���ű�2");
		System.out.println("--------------------------------------------");
		listMainApp.searchByName("�ֿ���");
		System.out.println();

	}

}
