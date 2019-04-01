package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import map.Student;

public class MapStudentService {
	
	private Map<String, Person> map = new HashMap<>();
	
	/**
	 * ������ �ʱ��ȭ
	 * */ 
	public MapStudentService() {//person id age name
		map.put("jang", this.create("jang", "������", 20));
		map.put("kim", this.create("kim", "����", 23));
		
		map.put("queen", this.create("queen", "��ȿ��", 30 ,70, 90 , 80 ));
		map.put("king", this.create("king", "�ں���", 25, 50 , 90 , 70 ));
		map.put("girl", this.create("girl", "�ҳ�ô�", 28, 40 , 80 , 90 ));
		
	}
	
	/**
	 *  Person �Ǵ� Student�� �����ؼ� �������ִ� �޼ҵ� �ۼ�
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
	 *  ��ü �˻�
	 *  (������ ������ ���� �߻���Ų�� : �޽��� "������ �����ϴ�.")
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
	 * key�� �ش��ϴ� ���� �˻�
	 *   :key�ش��ϴ� ������ ����Ҷ� 
	 *    [ Person�ΰ��� �̸��� ���
	 *     Student�ΰ��� �̸��� ���� ��� ] -> EndView���� 
	 *     ���°��� "id�� �����ϴ�." ���ܹ߻�
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
				System.out.println("����� �ʾҽ��ϴ�.");
			}
		}
		return null;
	}
	
	/**
	 * ��� : key�� Person�� ������ �޾� ����ϴ� �޼ҵ�
	 *        ����� �����ϸ�(id�ߺ�üũ!!) ���ܹ߻���Ų��.("��ϵ��� �ʾҽ��ϴ�.")
	 * */
	public void insert(Person person){
		
		//Iterator<String> keys= map.keySet().iterator();
		
		if(map.containsKey(person.getId())){
			EndView.printMessage("�ߺ��� ���� �ֽ��ϴ�!");
		}
		else {
			if(person instanceof Student) {
				Student buf = new Student();
				buf = (Student) person;
				create(buf.getId(),buf.getName(),buf.getAge(), buf.getKor(), buf.getEng(), buf.getMath());
				//Student�� ���
			}else {
				create(person.getId(),person.getName(),person.getAge());
				//�ƴҰ��
			}
		}
		
		//EndView.printAll(map);
	}
	
	/**
	 *  ����
	 *   : id�� �ش��ϴ� value�� �������� ������ ���ܹ߻�
	 *      (�������� �ʾҽ��ϴ�.)
	 * */
	public void  delete(String id) {
		//remove(Object key)
		try {
			if(map.containsKey(id)) {
				map.remove(id);
				EndView.printMessage("���� ����!");
			}
		}catch(Exception e) {
			EndView.printMessage("�����ϰ��� �ϴ� �����Ͱ� �����ϴ�.");
		}
		//EndView.printAll(map);
		
		
		
	}
	
	/**
	 * ����
	 *   ����, Person�ΰ�� - �̸��� ����
	 *         Student�ΰ��  - �̸�, ���� ,����,���м���(���� ����)
	 *         
	 *    ������ �ȵȴٸ� ���ܹ߻�
	 *    
	 * */
    public void update(Person person) { // �μ� Student or Person 
    	
    	Iterator<String> keys= map.keySet().iterator();
    	
    	while(keys.hasNext()) {
			String key = keys.next();
			try {
				if (key.equals(person.getId())) {
					if(person instanceof Student) {
						Student buf = new Student();
						buf = (Student) person;
						map.put(key, buf);
						//Student�� ���
					}else {
						map.put(key, person);
						//�ƴҰ��
					}    
				}
			}catch(Exception e){
				EndView.printMessage("��ϵ��� �ʾҽ��ϴ�.");
			}
			
		}
    	
    	//�μ��� ���� �� id�� ������ ���������� üũ
    	//�ִ� ���.... ã�� ��ü�� ���޵� ��ü�� ������ �����Ѵ�.
    	
    	
    	
  
    	
    }
}









