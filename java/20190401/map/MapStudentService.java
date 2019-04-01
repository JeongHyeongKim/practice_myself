package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import map.Student;

public class MapStudentService {
	
	private Map<String, Person> map = new HashMap<>();
	
	/**
	 * 데이터 초기기화
	 * */ 
	public MapStudentService() {//person id age name
		map.put("jang", this.create("jang", "장희정", 20));
		map.put("kim", this.create("kim", "김희선", 23));
		
		map.put("queen", this.create("queen", "이효리", 30 ,70, 90 , 80 ));
		map.put("king", this.create("king", "박보검", 25, 50 , 90 , 70 ));
		map.put("girl", this.create("girl", "소녀시대", 28, 40 , 80 , 90 ));
		
	}
	
	/**
	 *  Person 또는 Student를 생성해서 리턴해주는 메소드 작성
	 * */
	public Person create(String id, String name, int age , int ... i){
		
		if(i.length==0) {
			Person person = new Person(id, name, age);
			map.put(id,person);
			return person;
		}else {
			Student student = new Student(id, name, age, i[0],i[1],i[2]);
			map.put(id,student);
			return student;
		}
		
	}
	
	
	/**
	 *  전체 검색
	 *  (정보가 없으면 예외 발생시킨다 : 메시지 "정보가 없습니다.")
	 * */  //boolean containsKey(Object key);
	public  Map<String, Person> selectAll(){
		//Iterator<String> keys= map.keySet().iterator();
		if(map.size()!=0) {
			EndView.printAll(map);
			return map;
		}
		else return null;
	}
	
	/**
	 * key에 해당하는 정보 검색
	 *   :key해당하는 정보를 출력할때 
	 *    [ Person인경우는 이름만 출력
	 *     Student인경우는 이름과 총점 출력 ] -> EndView에서 
	 *     없는경우는 "id는 없습니다." 예외발생
	 * */
	//boolean containsKey(Object key);
	public Person searchByKey(String id){
		Iterator<String> keys= map.keySet().iterator();
		
		while(keys.hasNext()) {
			String key = keys.next();
			try {
				if (key.equals(id)) {
					EndView.printSearch(map.get(key));
					return map.get(key);
				}
			}catch(Exception e){
				System.out.println("등룍되지 않았습니다.");
			}
		}
		return null;
	}
	
	/**
	 * 등록 : key와 Person의 정보를 받아 등록하는 메소드
	 *        등록이 실패하면(id중복체크!!) 예외발생시킨다.("등록되지 않았습니다.")
	 * */
	public void insert(Person person){
		
		//Iterator<String> keys= map.keySet().iterator();
		
		if(map.containsKey(person.getId())){
			EndView.printMessage("중복된 값이 있습니다!");
		}
		else {
			if(person instanceof Student) {
				Student buf = new Student();
				buf = (Student) person;
				create(buf.getId(),buf.getName(),buf.getAge(), buf.getKor(), buf.getEng(), buf.getMath());
				//Student일 경우
			}else {
				create(person.getId(),person.getName(),person.getAge());
				//아닐경우
			}
		}
		
		//EndView.printAll(map);
	}
	
	/**
	 *  삭제
	 *   : id에 해당하는 value가 삭제되지 않으면 예외발생
	 *      (삭제되지 않았습니다.)
	 * */
	public void  delete(String id) {
		//remove(Object key)
		try {
			if(map.containsKey(id)) {
				map.remove(id);
				EndView.printMessage("삭제 성공!");
			}
		}catch(Exception e) {
			EndView.printMessage("삭제하고자 하는 데이터가 없습니다.");
		}
		//EndView.printAll(map);
		
		
		
	}
	
	/**
	 * 수정
	 *   만약, Person인경우 - 이름만 수정
	 *         Student인경우  - 이름, 국어 ,영어,수학수정(총점 변경)
	 *         
	 *    수정이 안된다면 예외발생
	 *    
	 * */
    public void update(Person person) { // 인수 Student or Person 
    	
    	Iterator<String> keys= map.keySet().iterator();
    	
    	while(keys.hasNext()) {
			String key = keys.next();
			try {
				if (key.equals(person.getId())) {
					if(person instanceof Student) {
						Student buf = new Student();
						buf = (Student) person;
						map.put(key, buf);
						//Student일 경우
					}else {
						map.put(key, person);
						//아닐경우
					}    
				}
			}catch(Exception e){
				EndView.printMessage("등록되지 않았습니다.");
			}
			
		}
    	
    	//인수로 전달 된 id를 꺼내서 존재유무를 체크
    	//있는 경우.... 찾은 객체를 전달된 객체으 정보로 수정한다.
    	
    	
    	
  
    	
    }
}









