package ex0326.sort;

public class Sort {

	static void insertSort(int data[]) {
		int temp=0;
		int j=0;
		for(int i=1; i<data.length; i++){
	        temp = data[i]; 
	        j = i; 
	        while(j > 0 && temp < data[j-1]){ 
	            data[j] = data[j-1]; 
	            j--;
	        }
	        data[j] = temp;
		}
		
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	
        
	public static void main(String[] args) {
		int arr[] = {5,7,1,2,4,3,8,9,6,10};
		insertSort(arr);

	}

}
