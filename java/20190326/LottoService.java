package ex0326.lotto;

public class LottoService {
	private int [] lotto; 
	
	/*
	 * 중복된 수를 찾는 메소드
	 */
	private void checkOverlap(int data[], int index) { 
		if (index==0) {}
		else {
			for(int i=0;i<index;i++) {
				if(data[i]==data[index]) {
					data[i]=((int) (Math.random()*45)+1);
					checkOverlap(data,index);
				}
				
			}
		}
		
	}
	
	void createData() {
		lotto = new int[6];
		for(int i=0;i<lotto.length;i++) { //->0인 부분을 다 비교하는 것 보다 index를 받아서 그 전 가지만 비교를 하면 더 효율적이다.
			lotto[i]=((int) (Math.random()*45))+1;
			checkOverlap(lotto, i);
		}
		
	}
	
	void sortDesc() {
		int temp=0;
		int j=0;
		for(int i=1; i<lotto.length; i++){
            temp = lotto[i]; // 삽입대상 임시 저장.
            j = i; //index 임시저장
            while(j > 0 && temp < lotto[j-1]){ //삽입대상이 정렬된 대상들보다 작은 경우가 있는 경우 
                lotto[j] = lotto[j-1]; //밀기
                j--; //다음 비교를 위해 인덱스 이동
            }
            lotto[j] = temp; //최종으로 삽입될 위치에 삽입대상 삽입
             
        }
		
	}
	
	void printData() {
		for(int i=lotto.length-1;i>=0;i--)
			System.out.print(lotto[i]+" ");
		System.out.println();
		
		
	}
	

}
