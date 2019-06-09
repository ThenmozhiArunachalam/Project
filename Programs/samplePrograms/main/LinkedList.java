package main;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	public int solution(int[] A) {
		List<Integer> list = new ArrayList<>();
		int val = A[0];
		for (int i = 0; i < A.length; i++) {
			list.add(val);
			if (val == -1)
				break;
			val = A[val];
		}
		return list.size();
	}
	
	public static int fibonacciWithSapceOptimized(int input) {
		if (input <= 1)
			return input;
		int a = 0, b = 1, c = 0;
		for (int i = 2; i <= input; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String aargs[]) {
		int arr[] = { 1, 4, -1, 3, 2 };
		LinkedList list = new LinkedList();
		System.out.println(list.fibonacciWithSapceOptimized(36)%1000000);
	}

}
