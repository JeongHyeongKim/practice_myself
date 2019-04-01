package ex0401;

import java.util.ArrayList;
import java.util.List;

public class ListMainApp {
	
	List<Student> list = new ArrayList<>(5); //필드를 이용한 다형성
	/*
	 * List에 데이터 추가
	 */
	
	public void addList(Student s) {
		list.add(s);
	}
	/*
	 * List에 있는 모든 정보의 출력
	 */
	public void printList() {
		System.out.println("List Size : "+list.size());
		System.out.println("---------- Student List ----------");
		for(Student s:list) {
			System.out.println(s);
		}
	}
	
	/*
	 * 정보 찾기 (검색)
	 */

	public void searchByName(String name) {
		for(Student s : list) {
			if(s.getName().equals(name)) {
				System.out.println(s);
				return; // return void 랑 무슨 차이인가?????
			}
		}
		System.out.println(name+"는(은) 없음..");
	}
	
	
	public static void main(String[] args) {
		ListMainApp listMainApp = new ListMainApp();
		listMainApp.addList(new Student("갈매기",10,"서울"));
		listMainApp.addList(new Student("갈매기1",20,"서울1"));
		listMainApp.addList(new Student("갈매기2",30,"서울2"));
		listMainApp.addList(new Student("갈매기3",40,"서울3"));
		listMainApp.addList(new Student("갈매기4",50,"서울4"));
		listMainApp.addList(new Student("갈매기5",60,"서울5"));
		
		listMainApp.printList();
		System.out.println("--------------------------------------------");
		listMainApp.searchByName("갈매기2");
		System.out.println("--------------------------------------------");
		listMainApp.searchByName("애용이");
		System.out.println();

	}

}
