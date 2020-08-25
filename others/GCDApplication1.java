/**
	阿里笔试题 1 ：小强想从 [1, A] 中选出一个整数 x，从 [1, B] 中选出一个整数 y。使得满足 x / y = a / b 的同时且
	x 和 y 的乘积最大。如果不存在这样的 x 和 y，请输出 "0 0"
	输入描述:
		输入一行包含四个整数 A, B, a 和 b.
		1 <= A,B,a,b <= 2e9
*/
public class GCDApplication1 {
	public static void main(String[] args) {
		int A = 1000, B = 5123, a = 999, b = 333;
		int gcd = gcd(a, b);

		// 约分
		a = a / gcd;
		b = b / gcd;

		// 在[1, A] 中最大能取 a 的多少倍的数
		int timesInA = A / a;
		// 在[1, B] 中最大能取 b 的多少倍的数
		int timesInB = B / b;

		// a > A 或 b > B
		if(timesInA == 0 || timesInB == 0) {
			System.out.println("0 0");

			return;
		}

		int minTimes = Math.min(timesInA, timesInB);
		int x = minTimes * a, y = minTimes * b;
		System.out.println(x + " " + y);
	}

	/**
		求 x, y 的最小公约数
	*/
	private static int gcd(int x, int y) {
		if(y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}
}