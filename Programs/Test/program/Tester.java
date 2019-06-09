package program;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Tester {
	  public static void main(String[] args) {
	    TreeMap tree = new TreeMap();
	    tree.put("ee", 3);
	    tree.put("aa", 1);
	    tree.put("cc", 2);
	    tree.put("gg", 4);
	    tree.put("aa", 5);
	    NavigableMap nvMap = tree.headMap("gg",false); //line #1
	    System.out.println(nvMap);
	    
	    Stream.of("ace", "jack", "queen", "king", "joker")
	    .mapToInt(card -> card.length())
	    .filter(len -> len > 3)
	    .peek(System.out::println)
	    .limit(2);
	  }
	}
