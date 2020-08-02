/**
	多重背包问题，与 01背包问题类似，只是每类物品的数量可能不止一个
*/
public class Knapsack2 {
	public static void main(String[] args) {
		// 问题提供的数据

		// costs[i] 表示第 i 种物品的代价
		int[] costs = {3, 7, 4, 8, 6, 5};
		// counts[i] 表示第 i 种物品的数量
		int[] counts = {1, 2, 3, 2, 1, 4};
		// values[i] 表示第 i 种物品的价值
        int[] values = {2, 3, 1, 0, 2, 3};
        int space = 13;

        // 将问题转换为 01 背包问题，需要重新构造数据
        int total = 0;
        for(int count: counts) {
        	total += count;
        }
        int[] costsNew = new int[total];
        int[] valuesNew = new int[total];

        System.arraycopy(costs, 0, costsNew, 0, costs.length);
        System.arraycopy(values, 0, valuesNew, 0, values.length);

        for(int i = 0, index = costs.length; i < costs.length; i++) {
        	while(counts[i] != 1) {
        		costsNew[index] = costs[i];
        		valuesNew[index] = values[i];
        		counts[i]--;

        		index++;
        	}
        }

        // 01 背包问题解决方案
        int[] dp = new int[space + 1];
        for(int i = 0; i < costsNew.length; i++) {
        	for(int j = space; j >= costsNew[i]; j--) {
        		dp[j] = Math.max(dp[j], dp[j - costsNew[i]] + valuesNew[i]);
        	}
        }

       System.out.println("最大价值为:" + dp[space]);
	}
}