package main;

import java.util.Arrays;

/*You are given an array  of  integers. Now there is another integer  which is unknown but you know its properties. The properties of the unknown number are:

. It is an integer.

. If you subtract all the elements of the array  individually from the number  and add all the differences then it adds to .

Your goal is to find the number .*/

public class HiddenNumber {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };
		int ans = Arrays.stream(arr).sum();
		if (ans % arr.length == 0) {
			int val = ans / arr.length;
			System.out.println(val);
		} else {
			System.out.println(-1);
		}
	}

}
