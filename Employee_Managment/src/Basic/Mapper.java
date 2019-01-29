package Basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Mapper {
	private static HashMap<String,Employee> map = new HashMap<String,Employee>();
	
	public static void put(String iD,Employee e) {
		 map.put(iD,e);
	}
	
	public static Employee get(String iD) {
		return map.get(iD);
	}
	
	public static boolean containsKey(String iD) {
		return map.containsKey(iD);
	}

	public static Iterator<Entry<String, Employee>> iterate() {
		return map.entrySet().iterator();
	}

	public static void remove(String iD) {
		map.remove(iD);
	}
	
	public static int size() {
		return map.size();
	}
}
