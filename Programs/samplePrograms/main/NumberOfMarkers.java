package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfMarkers {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(), n;
		int arr[][];
		for (int i = 0; i < t; i++) {
			n = s.nextInt();
			arr = new int[n][2];
			for (int j = 0; j < n; j++) {
				arr[j][0] = s.nextInt();
				arr[j][1] = s.nextInt();
			}
			printNoOFMarkers(arr, n);
		}
	}

	private static void printNoOFMarkers(int[][] arr, int n) {
		List<Integer> list = new ArrayList<>();
		int start, end;
		for (int i = 0; i < n; i++) {
			start = arr[i][0];
			end = arr[i][1];
			for (int j = start; j <= end; j++) {
				if (!list.contains(j)) {
					list.add(j);
				}
			}
		}
		System.out.println(list.size());
	}
}
