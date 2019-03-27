package gs.mvc.service;

import gs.mvc.dto.Electronics;
import gs.mvc.view.EndView;

public class ElectronicsService {

	private static ElectronicsService service = new ElectronicsService();
	String data[][]= {
			{"100" , "에어컨" , "250000", "삼성 무풍에어컨"} ,
		      {"200" , "세탁기" , "350000", "LG 세탁짱"} ,
		      {"300" , "냉장고" , "500000", "냉장고입니다."} ,
		      {"400" , "전자렌지" , "640000", "전자렌즈입니다."} ,
		      {"500" , "밥통" , "450000", "쿠쿠밥솥 최고!"} 
	};
	public static int count; //Electronics타입 배열 안에 실제 들어있는 전자 제품 개수를 check하는 변수
	
	public Electronics elecArr[] = new Electronics [20];
	
	
	private ElectronicsService() {
		for (int i=0;i<data.length;i++) {
			elecArr[i] = new Electronics(Integer.parseInt(data[i][0]), data[i][1], Integer.parseInt(data[i][2]),
											data[i][3]);
			count++;
			System.out.println("elecArr"+i+elecArr[i]);
			System.out.println("cnt : "+count);
		}
		
	} //외부에서 객체 생성 불가하도록 설정
	
	public  static  ElectronicsService getService(){
		return service;
	} //외부에서 객체를 호출 해주게 하기 위한 메소드 => 매번 사용하니까 아예 맴버 변수로 빠지는게 나음!!!!!
	
	
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
	
	public boolean update(Electronics elec) { // 수정 성공true, 실패false
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
	
	// 수정 성공true, 실패false
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
