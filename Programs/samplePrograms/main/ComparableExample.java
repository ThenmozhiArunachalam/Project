package main;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample implements Comparable<ComparableExample> {
	private double rating;
	private String name;
	private int year;

	// Used to sort movies by year
	public int compareTo(ComparableExample m) {
		System.out.println(this.year + " & " + m.year + " : " + (this.year - m.year));
		return m.year - this.year;
	}
	/** For Multi level comparator not for comparable*/
	/*int compareName = cust1.getCustName()
            .compareTo(cust2.getCustName());
    int compareCity = cust1.getCustCity()
            .compareTo(cust2.getCustCity());
    int compareAge = cust1.getCustAge()
            .compareTo(cust2.getCustAge());

    // 3-level comparison using if-else block
    if(compareName == 0) {
        return ((compareCity == 0) ? compareAge : compareCity);
    }
    else {
        return compareName;
    }*/
	
	// Constructor
	public ComparableExample(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}

	// Getter methods for accessing private data
	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public static void main(String[] args) {
		ArrayList<ComparableExample> list = new ArrayList<ComparableExample>();
		list.add(new ComparableExample("Force Awakens", 8.3, 2015));
		list.add(new ComparableExample("Star Wars", 8.7, 1977));
		list.add(new ComparableExample("Empire Strikes Back", 8.8, 1980));
		list.add(new ComparableExample("Return of the Jedi", 8.4, 1983));

		Collections.sort(list);

		System.out.println("Movies after sorting : ");
		for (ComparableExample movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
	}
}
