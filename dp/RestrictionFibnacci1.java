/**
	小明腿瘸了，左腿只能走一步，右腿可以走一步或者两步，而且小明左腿不能连续走（即左腿用过一次，下一次必定用右腿）。
	对于走楼梯，走左腿与走右腿我们可看作不同的走法，问有多少种？

	dp[k] 表示走到第 k 阶楼梯的走法
		1. 当走到第 k 阶楼梯使用的是右脚有：dp[k] = dp[k - 1] + dp[k - 2]
		2. 当走到第 k 阶楼梯使用的是左脚有（即走到第 k - 1 阶楼梯时，必定使用右脚）：dp[k] = dp[k - 1] = dp[k - 2] + dp[k - 3]
	根据组合原理有： dp[k] = dp[k - 1] + dp[k - 2] + dp[k - 2] + dp[k - 3] = dp[k - 1] + 2 * dp[k - 2] + dp[k - 3]
*/
public class RestrictionFibnacci1 {
	public static void main(String[] args) {
		int level = Integer.valueOf(args[0]);
		int count = 0;
		if(level <= 0) {
			count = 0;
		} else if(level == 1) {
			count = 2;
		} else if(level == 2) {
			count = 4;
		} else {
			int a = 1, b = 2, c = 4;
			for(int i = 3; i <= level; i++) {
				count = a + 2 * b + c;

				a = b;
				b = c;
				c = count;
			}
		}

		System.out.print(String.format("小明上 %d 阶楼梯总共有 %d 种方法", level, count));
	}
}