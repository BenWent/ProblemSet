/**
	360 笔试题 2：玩家可以拥有 m 个英雄，在游戏中提供了 n 件装备给英雄使用，不同的英雄拥有不同数目的装备时将获得不同的攻击值，每一个英雄可以拥有
	0 件或多件装备。请问如何分配装备这 n 件装备，可以使得所有 m 个英雄获得的攻击值的和最大？

	二维背包问题，只需三次循环就可以了，最外的两层是为了遍历二维数组，最内一层才是真正的背包逻辑
*/
public class KnapsackApplication1 {
	public static void main(String[] args) {
		int m = 2, n = 3;
		int[][] equips = {
			{5, 6, 7},
			{7, 8, 9}
		};

		// dp[v] 表示 v 件装备得到最合理地使用使 m 个英雄获得的攻击值的和最大
		int[] dp = new int[n + 1];
		for(int i = 0; i < m; i++) {
			for(int j = n; j >= 1; j--) {
				for(int k = j; k >= 1; k--) {
					// 第 i 个人拿 k 件装备时，前面 i - 1 个人应该拿 dp[j - k] 件装备
					dp[j] = Math.max(dp[j], dp[j - k] + equips[i][k - 1]);
				}
			}
		}

		System.out.println(dp[n]);
	}
}