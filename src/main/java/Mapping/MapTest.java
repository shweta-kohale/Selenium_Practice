package Mapping;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		
		map.put(100, "Tom");
		map.put(200, "Shweta");
		map.put(300, "Sanvi");
		map.put(400, "Ananya");
//		map.put(null, null);
//		map.put(500, null);
		System.out.println(map.get(100));
		System.out.println(map.get(null));
		System.out.println(map.get(500));
		
		map.forEach((k,v)-> System.out.println(k + ":" + v));

	}

}
