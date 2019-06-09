package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class HashExample {
	public static void main(String args[]) {
		/**
		 * HashTable: It does not allow null for both key and value. It will throw
		 * NullPointerException. Hashtable does not maintain insertion order. The order
		 * is defined by the Hash function. So only use this if you do not need data in
		 * order. It is synchronized. It is slow. Only one thread can access in one
		 * time. HashTable is thread safe. HashTable uses Enumerator to iterate through
		 * elements.
		 */
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(1, "Hi");
		// duplicate value not key
		table.put(2, "Hi");
		table.put(3, "HII");
		table.put(4, "GGGG");
		// duplicate key
		table.put(3, "GGGG");
		table.put(0, "GGGG");
		table.put(11, "Hi");
		// duplicate value not key
		table.put(22, "Hi");
		table.put(13, "HII");
		table.put(14, "GGGG");
		// duplicate key
		table.put(13, "GGGG");
		table.put(20, "GGGG");
		table.put(21, "Hi");
		// duplicate value not key
		table.put(22, "Hi");
		table.put(23, "HII");
		table.put(24, "GGGG");
		// duplicate key
		table.put(23, "GGGG");
		table.put(30, "GGGG");
		// doesnot accept null value
		// table.put(2, null); it will throw null pointer Exception
		System.out.println(table);

		/**
		 * HashMap: It allows null for both key and value. HashMap does not maintain
		 * insertion order. The order is defined by the Hash function. It is not
		 * synchronized. It will have better performance. HashMap are not thread safe,
		 * but you can use Collections.synchronizedMap(new HashMap<K,V>())
		 */
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Hi");
		// duplicate value not key
		map.put(2, "Hi");
		map.put(3, "HII");
		map.put(5, "wefw");
		// duplicate key
		map.put(4, null);// accept null value
		map.put(3, "GGGG");
		map.put(0, "ajd");
		map.put(null, null);
		map.put(null, "1");
		System.out.println(map);

		/**
		 * HashSet: insertionOrder, not synchronized,not allow duplicate values
		 */
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(3);
		set.add(0);
		set.add(2);
		set.add(2);
		set.add(null);
		System.out.println(set);

	}
}
