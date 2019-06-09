package main;

import java.util.Arrays;
import java.util.stream.Stream;

/*You are given some denominations of coins in an array (int denom[])and infinite supply of all of them. 
 * Given an amount (int amount), find the minimum number of coins required to get the exact amount.*/
public class CoinDynamic {

	public static void main(String args[]) {
		int coins[] = { 1, 5, 6, 8 };
		int amount, ans;

		amount = 11;
		ans = solve(coins, amount, coins.length);
		System.out.println("Ans: " + ans);

		int coins1[] = { 9, 5, 6, 1 };
		amount = 10;
		ans = solve(coins1, amount, coins1.length);
		System.out.println("Ans: " + ans);

	}

	private static int solve(int[] coins, int amount, int length) {
		int T[][] = new int[length + 1][amount + 1];
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= amount; j++) {
				if (i == 0 || j == 0) {
					T[i][j] = j;
				} else if (coins[i - 1] <= j) {
					T[i][j] = min(T[i - 1][j], (T[i][j - coins[i - 1]] + 1));
				} else {
					T[i][j] = T[i - 1][j];
				}
			}
		}
		printArrayStream(T, length, amount);
		return T[length][amount];
	}

	private static void printArrayStream(int[][] l, int n, int m) {
		Stream.of(l).map(Arrays::toString).forEach(System.out::println);
	}

	private static int min(int a, int b) {
		return (a < b) ? a : b;
	}

}
