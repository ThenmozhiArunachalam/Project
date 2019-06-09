package main;
// 0 1 1 2 3 5 8 13...
public class Fibonacci {
	static long beforeUsedMem, afterUsedMem, startTime, endTime;

	public static void main(String args[]) {
		int input = 25, ans;

		beforeMethodCall();
		ans = fibonacciWithRecursion(input);
		afterMethodCall("fibonacciWithRecursion", ans);

		beforeMethodCall();
		ans = fibonacciWithDynamic(input);
		afterMethodCall("fibonacciWithDynamic", ans);

		beforeMethodCall();
		ans = fibonacciWithSapceOptimized(input);
		afterMethodCall("fibonacciSapceOptimized", ans);
	}

	/*
	 * this do a lot of repeated work. So this is a bad implementation for nth
	 * Fibonacci number. Time Complexity: T(n) = T(n-1) + T(n-2) which is
	 * exponential. Extra Space: O(n) if we consider the function call stack size,
	 * otherwise O(1).
	 */
	private static int fibonacciWithRecursion(int n) {
		if (n <= 1)
			return n;
		return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
	}

	/*
	 * Time Complexity: O(n) Extra Space: O(n)
	 */
	private static int fibonacciWithDynamic(int input) {
		int f[] = new int[input + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= input; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[input];

	}

	/*
	 * Time Complexity: O(n) Extra Space: O(1)
	 */
	private static int fibonacciWithSapceOptimized(int input) {
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

	private static void beforeMethodCall() {
		startTime = System.currentTimeMillis();
		beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	private static void afterMethodCall(String methodName, int ans) {
		afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		endTime = System.currentTimeMillis();
		System.out.println(methodName + " ans: " + ans + " time taken " + (endTime - startTime) + " memory usage "
				+ (afterUsedMem - beforeUsedMem));
	}

}
