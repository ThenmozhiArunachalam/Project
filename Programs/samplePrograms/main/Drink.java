package main;

import java.util.Iterator;
import java.util.TreeSet;

public class Drink implements Comparable {
	@Override
	public String toString() {
		return "Drink [name=" + name + "]";
	}

	public String name;

	public int compareTo(Object o) {
		System.out.println(o.toString());
		return 0;
	}

	public static void main(String args[]) {
		Drink one = new Drink();
		Drink two = new Drink();
		one.name = "Coffee";
		two.name = "Tea";
		TreeSet set = new TreeSet();
		set.add(one);
		set.add(two);
		System.out.println(set);
		Iterator iterator;
		iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
	}
}