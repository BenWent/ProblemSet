/**
	拼多多笔试 3：cost 或 value 可以为负数的背包问题，cost 为负数表示可以为背包增大 |cost| 的容量
    答案来源：https://www.cnblogs.com/hua-dong/p/13599577.html
*/
public class Knapsack3 {
	public static void main(String[] args) {
        // 背包容量
        int space = 4;
		// costs[i] 表示第 i 种物品的代价
		int[] costs = {-1, 1, -1, 6};
		// values[i] 表示第 i 种物品的价值
        int[] values = {-1, -1, 1, 6};

        int[] dp = new int[10000];
        int cap = space;
        int extra = 0;
        for(int i = 0; i < costs.length; i++) {
            if(costs[i] < 0) {
                // 增加背包容量的同时，也要增加价值量（直接将物品 i 放入背包，增加了价值 values[i]）
                cap -= costs[i];
                extra += values[i];

                costs[i] = -costs[i];
                // 在使用 0-1 背包解题时，当选择了物品 i 时，代表要收回 |costs[i]|的空间，就需要 values[i] 的价值
                values[i] = -values[i];
            }
        }

        // 0-1 背包
        for(int i = 0; i < costs.length; i++) {
            for(int j = cap; j >= costs[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - costs[i]] + values[i]);
            }
        }

        int res = 0;
        for(int i = 1; i <= cap; i++) {
            res = Math.max(res, dp[i]);
        }
        res += extra;

        System.out.println("结果为：" + res);
	}
}