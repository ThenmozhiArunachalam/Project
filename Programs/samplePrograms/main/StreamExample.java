package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String args[]) {

		int a[] = { 1, 2, 3, 4 };
		Stream.of(a).forEach(System.out::print);

		/** forEach */
		Integer arr[] = { 1, 2, 3, 4 };
		System.out.println("---------forEach--------");
		Stream.of(arr).forEach(e -> System.out.print(e));
		System.out.println();
		Stream.of(arr).forEach(System.out::print);
		// for parallel input
		System.out.println();

		/** forEachOrdered */
		/**
		 * following is not guaranteed since the order is not kept..It will print in
		 * different order.
		 */
		Stream.of(arr).parallel().forEach(System.out::print);
		System.out.println();
		/** to overcome this issue can use foreachOrdered for this */
		Stream.of(arr).parallel().forEachOrdered(System.out::print);

		List<String> list = new ArrayList<>();
		list.add("Green");
		list.add("Yellow");
		list.add("Red");
		System.out.println();
		list.stream().forEach(System.out::print);

		List<SimplePOJO> pojos = new ArrayList<>();
		pojos.add(new SimplePOJO(2, "test"));
		pojos.add(new SimplePOJO(3, "test1"));
		System.out.println();
		pojos.stream().forEach(System.out::print);
		System.out.println();
		pojos.stream().forEachOrdered(System.out::print);
		System.out.println();
		pojos.stream().forEach(e -> e.getCalculation(e.getId() + 1));

		/** MAP */
		System.out.println("---------Map---------");
		pojos.stream().map(i -> i.getId() + " mapped to " + i.getName()).forEach(System.out::println);
		List<String> ansList = pojos.stream().map(i -> i.getId() + " mapped to " + i.getName())
				.collect(Collectors.toList());
		System.out.println(ansList);
		List<Integer> ansList1 = pojos.stream().map(i -> i.getId() * i.getId()).collect(Collectors.toList());
		System.out.println(ansList1);
		pojos.stream().map(i -> {
			i.setId(i.getId() * i.getId());
			return i;
		}).forEach(System.out::print);
		System.out.println();

		pojos.stream().filter(e -> e.getName().equals("test1")).map(i -> i.getId() * i.getId())
				.forEach(System.out::println);

		/** FLATMAP */
		List<List<SimplePOJO>> hierarchyList = new ArrayList<>();
		hierarchyList.add(pojos);
		hierarchyList.add(pojos);
		System.out.println("---------FlatMap---------");
		hierarchyList.stream().flatMap(Collection::stream).forEach(System.out::println);
		hierarchyList.stream().map(e -> e).forEach(System.out::println);

		/** peek */
		/**
		 * like for each method but can't use for more than one time. but we can use
		 * peek several times.
		 */
		System.out.println("-----Peek-----");
		pojos.stream().peek(e -> e.setId(e.getId()+1)).peek(System.out::println);
		
		/** SKIP*/
		System.out.println("-----Skip-----");
		Stream.of(arr).skip(2).forEach(System.out::print);
		System.out.println();
		System.out.println("-----Limit-----");
		/** Limit*/
		Stream.of(arr).limit(2).forEach(System.out::print);
		

	}
}
