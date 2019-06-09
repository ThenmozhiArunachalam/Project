package main;

import java.util.Date;

public class EqualsAndHashCodeTest {
	public static void main(String args[]) {
		EqualsHashcodeCompareTo james = new EqualsHashcodeCompareTo("James", 21, new Date(1980, 12, 1));
		EqualsHashcodeCompareTo same = new EqualsHashcodeCompareTo("James", 21, new Date(1980, 12, 1));
		EqualsHashcodeCompareTo similar = new EqualsHashcodeCompareTo("Harry", 21, new Date(1981, 12, 1));
		System.out.println(james.equals(same));
		System.out.println(james.hashCode() == same.hashCode());
		System.out.println(james.equals(null));
		System.out.println(james.equals(similar));
		System.out.println(james.hashCode() == similar.hashCode());
	}
}
