package ex0326.lotto;

public class LottoService {
	private int [] lotto; 
	
	/*
	 * �ߺ��� ���� ã�� �޼ҵ�
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
		for(int i=0;i<lotto.length;i++) { //->0�� �κ��� �� ���ϴ� �� ���� index�� �޾Ƽ� �� �� ������ �񱳸� �ϸ� �� ȿ�����̴�.
			lotto[i]=((int) (Math.random()*45))+1;
			checkOverlap(lotto, i);
		}
		
	}
	
	void sortDesc() {
		int temp=0;
		int j=0;
		for(int i=1; i<lotto.length; i++){
            temp = lotto[i]; // ���Դ�� �ӽ� ����.
            j = i; //index �ӽ�����
            while(j > 0 && temp < lotto[j-1]){ //���Դ���� ���ĵ� ���麸�� ���� ��찡 �ִ� ��� 
                lotto[j] = lotto[j-1]; //�б�
                j--; //���� �񱳸� ���� �ε��� �̵�
            }
            lotto[j] = temp; //�������� ���Ե� ��ġ�� ���Դ�� ����
             
        }
		
	}
	
	void printData() {
		for(int i=lotto.length-1;i>=0;i--)
			System.out.print(lotto[i]+" ");
		System.out.println();
		
		
	}
	

}
