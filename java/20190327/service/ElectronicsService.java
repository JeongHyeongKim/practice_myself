package gs.mvc.service;

import gs.mvc.dto.Electronics;
import gs.mvc.view.EndView;

public class ElectronicsService {

	private static ElectronicsService service = new ElectronicsService();
	String data[][]= {
			{"100" , "������" , "250000", "�Ｚ ��ǳ������"} ,
		      {"200" , "��Ź��" , "350000", "LG ��Ź¯"} ,
		      {"300" , "�����" , "500000", "������Դϴ�."} ,
		      {"400" , "���ڷ���" , "640000", "���ڷ����Դϴ�."} ,
		      {"500" , "����" , "450000", "������ �ְ�!"} 
	};
	public static int count; //ElectronicsŸ�� �迭 �ȿ� ���� ����ִ� ���� ��ǰ ������ check�ϴ� ����
	
	public Electronics elecArr[] = new Electronics [20];
	
	
	private ElectronicsService() {
		for (int i=0;i<data.length;i++) {
			elecArr[i] = new Electronics(Integer.parseInt(data[i][0]), data[i][1], Integer.parseInt(data[i][2]),
											data[i][3]);
			count++;
			System.out.println("elecArr"+i+elecArr[i]);
			System.out.println("cnt : "+count);
		}
		
	} //�ܺο��� ��ü ���� �Ұ��ϵ��� ����
	
	public  static  ElectronicsService getService(){
		return service;
	} //�ܺο��� ��ü�� ȣ�� ���ְ� �ϱ� ���� �޼ҵ� => �Ź� ����ϴϱ� �ƿ� �ɹ� ������ �����°� ����!!!!!
	
	
	public Electronics[] selectAll() {
		
		return elecArr;
		
	}
	public Electronics searchByModelNo(int modelNo) {
		for(int i=0;i<count;i++) {
			if(elecArr[i].getModelNo()==modelNo) {
				return elecArr[i];
				
			}
			else if(i==count)
				return null;
		}
		return null;
	}
	
	public boolean update(Electronics elec) { // ���� ����true, ����false
		int modelNo = elec.getModelNo();
		Electronics result = searchByModelNo(modelNo);
		System.out.println(result.getModelName());
		System.out.println(result.getModelPrice());
		
		for(int i=0;i<count;i++)
			if(elecArr[i].getModelNo()==elec.getModelNo()) 
			{	
				elecArr[i].setModelPrice(elec.getModelPrice());
				elecArr[i].setModelDetail(elec.getModelDetail());
				return true;}
	
		
		return false;
	}
	
	// ���� ����true, ����false
	public boolean insert(Electronics elec) {
		if (count==20) {
			System.out.println("count exception");
			return false;}
		Electronics model = searchByModelNo(elec.getModelNo());
      
		if (model!=null) {
			System.out.println("modelno exception");
			return false;}
		for(int i=0;i<count;i++)
			if(elecArr[i].getModelName().equals(elec.getModelName())) 
			{	
				System.out.println(elecArr[i].getModelName()+" "+elec.getModelName());
				System.out.println("modelname exception");
				return false;}
		
		elecArr[count]=elec;
		count++;
		return true; 
		
	}
	
	


}
