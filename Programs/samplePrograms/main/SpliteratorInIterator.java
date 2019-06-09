package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorInIterator {
	
	public static void main(String args[]) {
		List<String> stringList =new ArrayList<>();
		stringList.add("Apple Fruit");
		stringList.add("Orange juice");
		stringList.add("Litchy ice cream");
		Spliterator<String> stringSpliterator = stringList.stream().spliterator();
		
		List<Integer> intList = new ArrayList<>();
		intList.add(5);
		intList.add(10);
		intList.add(3);
		Spliterator<Integer> intSpliterator = intList.stream().spliterator();
		System.out.println(stringSpliterator.hasCharacteristics(intSpliterator.characteristics()));
		
		System.out.println();
		
	}

}
