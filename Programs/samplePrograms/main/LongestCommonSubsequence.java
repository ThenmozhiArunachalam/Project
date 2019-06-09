package main;

import java.util.Arrays;
import java.util.stream.Stream;

public class LongestCommonSubsequence {

	public static void main(String args[]) {
		String a, b;
		char x[], y[];
		int ans;

		a = "ABC";
		b = "AAC";
		x = a.toCharArray();
		y = b.toCharArray();
		ans = solve(x, y, x.length, y.length);
		System.out.println("Ans: " + ans);

		a = "AGGTAB";
		b = "GXTXAYB";
		x = a.toCharArray();
		y = b.toCharArray();
		ans = solve(x, y, x.length, y.length);
		System.out.println("Ans: " + ans);

	}

	private static int solve(char[] x, char[] y, int n, int m) {
		int l[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					l[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					l[i][j] = l[i - 1][j - 1] + 1;
				} else {
					l[i][j] = max(l[i - 1][j], l[i][j - 1]);
				}
			}
		}
		printArrayStream(l, n, m);
		printLCS(l, n, m, x, y);
		return l[n][m];

	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private static void printArrayStream(int[][] l, int n, int m) {
		Stream.of(l).map(Arrays::toString).forEach(System.out::println);
	}

	private static void printLCS(int[][] l, int n, int m, char[] x, char[] y) {
		int count = 1, j = 1, a = 1;
		for (int i = 1; i <= m; i++) {
			for (j = a; j <= n; j++) {
				if (l[j][i] == count) {
					count++;
					a++;
					System.out.print(x[j - 1]);
					break;
				}
			}
		}
		System.out.println();
	}

}
