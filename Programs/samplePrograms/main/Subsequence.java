package main;

public class Subsequence {

	public static void main(String args[]) {
		int n = 7;
		String str = "apbebda";
		char arr[] = str.toCharArray();
		int k = (n / 2) + 1;
		int l = n - k;
		char x[] = new char[k];
		char y[] = new char[l];
		for (int i = 0; i < k; i++) {
			x[i] = arr[i];
		}
		for (int i = 0, j = k; j < n; i++, j++) {
			y[i] = arr[j];
		}
		int t[][] = new int[k + 1][l + 1];
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j <= l; j++) {
				if (i == 0 | j == 0) {
					t[i][j] = 0;
				} else if (x[i-1] == y[j-1]) {
					t[i][j] = t[i - 1][j] + 1;
				} else {
					t[i][j] = max(t[i - 1][l], t[i][j - 1]);

				}

			}
		}

		System.out.println(t[k][l]);
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
