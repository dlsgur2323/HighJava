package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		/*
		 *  Map ==> key값과 value값을 한 쌍으로 관리하는 객체
		 *  - key값은 중복을 허용하지 않고, 순서(index)가 없다. (Set의 특징)
		 *  - value값은 중복을 허용한다.
		 */
		
		HashMap<String, String> map = new HashMap<>();
		
		// 자료 추가 ==> put(key, value)
		
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1111-1111");
		
		System.out.println("map ==> " + map);
		
		// 자료 수정 ==> 데이터를 추가할 때 key값이 같으면 나중에 추가한 value값이 저장 된다.
		
		map.put("addr", "서울");
		System.out.println("map ==> " + map);
		
		// 자료 삭제 ==> remove(key값) ==> 'key값'이 같은 데이터를 찾아서 삭제한다.
		// 						   ==>	반환값 : 삭제된 value 값이 반환된다.
//		String removeData = map.remove("tel");
//		System.out.println("map ==> " + map);
//		System.out.println("삭제된 value = " + removeData);
		
		// 자료 읽기 ==> get(key) ==> key값이 같은 value값을 반환한다.
		System.out.println("이름 : " + map.get("name"));
		System.out.println("전화 : " + map.get("tel"));
		System.out.println();
		
		// key값의 존재 여부를 나타내는 메소드 : containsKey(key);
		// 		==> 해당 key값이 있으면 true, 없으면 false를 반환한다.
		System.out.println("tel 키값의 존재 여부 : " + map.containsKey("tel"));
		System.out.println("age 키값의 존재 여부 : " + map.containsKey("age"));
		System.out.println();
		
		// Map에 저장된 모든 key값들을 읽어와 전체 Map 데이터를 처리하는 방법
		
		// 방법1. keySet()메소드
		//		==> Map의 모든 key값을 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();
		
		Iterator<String> keyIt = keySet.iterator();
		System.out.println("Iterator 이용하기...");
		while(keyIt.hasNext()){
			String key = keyIt.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("-------------------------------------------");
		
		// 방법2: keySet()의 결과를 향상된 for문으로 사용하기
		System.out.println("향상된 for문 이용하기...");
		for(String key : keySet){
			String value = map.get(key); 
			System.out.println(key + " : " + value);
		}
		System.out.println("-------------------------------------------");
		
		// 방법3 : value값만 읽어와 처리하기 --> values() 메소드 이용
		System.out.println("value 값만 읽어오기...");
		for(String value : map.values()){
			System.out.println(value);
		}
		System.out.println("-------------------------------------------");
		
		// 방법4 : Map에는 Entry라는 내부 class가 만들어져 있다.
		//		  이 Entry클래스는 key와 value라는 멤버변수로 구성되어 있다.
//				 Map에서는 이 Entry클래스를 Set 형식으로 저장하여 관리한다.
//				- Map에 저장된 전체 Entry 객체를 가져오기 (가져온 Entry 객체들은 Set형식으로 되어있다.)
//					==> entrySet()메소드를 이용한다.
		// Entry라는 내부 객체 전체 가져오기
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key값 : " + entry.getKey());
			System.out.println("value값 : " + entry.getValue());
		}
		System.out.println("-------------------------------------------");
		
		
	}

}































