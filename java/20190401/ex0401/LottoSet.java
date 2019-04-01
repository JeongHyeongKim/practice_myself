package ex0401;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoSet {
	
	//Set<Integer> set = new HashSet<>(6); //set -> 중봅없이 요소 넣을 수 있음.
	Set<Integer> set = new TreeSet<>();  //요소 정렬
	/*
	 * 로도번호 6개를 중복없이 추가
	 */
	
	public LottoSet() {
		Random r = new Random();
		
		while(set.size()<6) {
			int no = r.nextInt(10)+1;
			boolean result = set.add(no);
			System.out.println(no+"의 결과  : "+result+" : size : "+set.size());
		}
		
		System.out.println("최종 결과");
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
