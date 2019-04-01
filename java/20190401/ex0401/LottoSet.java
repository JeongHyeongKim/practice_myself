package ex0401;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoSet {
	
	//Set<Integer> set = new HashSet<>(6); //set -> �ߺ����� ��� ���� �� ����.
	Set<Integer> set = new TreeSet<>();  //��� ����
	/*
	 * �ε���ȣ 6���� �ߺ����� �߰�
	 */
	
	public LottoSet() {
		Random r = new Random();
		
		while(set.size()<6) {
			int no = r.nextInt(10)+1;
			boolean result = set.add(no);
			System.out.println(no+"�� ���  : "+result+" : size : "+set.size());
		}
		
		System.out.println("���� ���");
		System.out.println(set);
		System.out.println();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int no = it.next();
			System.out.println(no);
		}
	}
	
	
	
	public static void main(String[] args) {	
		new LottoSet();

	}

}
