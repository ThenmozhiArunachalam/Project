package main;

import java.util.List;
import java.util.Scanner;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegersRange {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 3; j++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				int k = sc.nextInt();
				solve(arr, n, l, r, k);
			}

		}

	}

	private static void solve(int[] arr, int n, int l, int r, int k) {
		List<int[]> count = Stream.of(arr).distinct().collect(Collectors.toList());
		Stream<Integer> a =IntStream.range(l, r).boxed();
		System.out.println(count);
//		if (count >= k) {
//			System.out.println("yes");
//		} else {
//			System.out.println("No");
//		}
	}

}
