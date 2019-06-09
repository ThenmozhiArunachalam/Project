package main;

import java.util.LinkedList;

/*You are given an array  of  integers. Each integer is a single digit number in the range . You are also given a number . Now, you need to count how many subsequences of the array  exist such that they form a  digit valid number.

A subsequence of size  is called a valid number if there are no leading zeros in the number formed.
*/

public class NumberFormation {

	public static void main(String args[]) {
		int arr[] = { 1, 1, 0, 1, 0 };
		int n = 5;
		int k = 3;
		int val = k - 1;
		int colSize = n + val;
		int ans[][] = new int[n][colSize];
		int count = 0;
		int sol=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < colSize; j++) {
				if (j < val) {
					ans[i][j] = 0;
				} else if (i < val) {
					if (arr[i] != 0) {
						ans[i][j] = 1;
					} else {
						ans[i][j] = 0;
					}
				} else {
					if (ans[i - val][j - val] == 0 && ans[i - 1][j - 1] == 0) {
						ans[i][j] = sol;
					} else {
						ans[i][j] = count++;
						sol = ans[i][j];
					}
				}
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
		System.out.println(count - 2);
	}

}
