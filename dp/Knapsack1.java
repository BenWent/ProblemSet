import java.util.Arrays;

/**
	01 背包问题
    给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的重量，v[i]表示第i件商品的价值。再给定一个整数bag，
	要求你挑选商品的重量加起来一定不能超过bag，返回满足这个条件下，你能获得的最大价值。
*/
public class Knapsack1{
    public static void main(String[] args) {
        int[] weights = {3, 7, 4, 8, 6, 5};
        int[] values = {2, 3, 1, 0, 2, 3};
        int space = 13;

        // System.out.println(violation2(weights, values, space, 0, 0));
        // System.out.println(violation3(weights, values, space, weights.length));
        // System.out.println(solution(weights, values, space));
        System.out.println(solution2(weights, values, space));
    }

    /**
     * 自定义实现，由于将额外引入了一个 最大金额 变量 sum ，使得递归过程中出现三个变量，使用动态规划进行优化时会引入一个三维
     * 数组，代价太高。
     */
    private static int violation1(int[] weights, int[] values, int space, int i, int sum) {
        if (space < 0) {
            return sum - values[i - 1];
        }

        if (i == weights.length) {
            return sum;
        }

        return Math.max(violation1(weights, values, space, i + 1, sum)
                , violation1(weights, values, space - weights[i], i + 1, sum + values[i]));
    }

    /**
     * 左程云版
     */
    private static int violation2(int[] weights, int[] values, int space, int i, int usedBag) {
        if (usedBag > space) {
            return -values[i - 1];
        }

        if (i == weights.length) {
            return 0;
        }

        return Math.max(values[i] + violation2(weights, values, space, i + 1, usedBag + weights[i])
                , violation2(weights, values, space, i + 1, usedBag));
    }

    /**
     * github：求解0-1背包问题与华为笔试
     */
    private static int violation3(int[] weights, int[] values, int space, int n) {
        if (n == 0)
            return 0;
        if (space >= weights[n - 1])
            return Math.max(violation3(weights, values, space, n - 1)
                    , violation3(weights, values, space - weights[n - 1], n - 1) + values[n - 1]);
        else
            return violation3(weights, values, space, n - 1);
    }

    /**
     *  根据 violation3 优化的动态规划实现
     * */
    private static int solution(int[] costs, int[] values, int space) {
        // dp[i][j] 表示背包容积为 j ，且有 i 种物品可选的环境中的最大利润值
        int[][] dp = new int[costs.length + 1][space + 1];
        // dp[0][0 - space] = 0：背包空间有余量，但是不能选择物品装入背包中

        for (int i = 0; i < costs.length; i++) {
            for (int j = costs[i]; j <= space; j++) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - costs[i]] + values[i]);
            }
        }

        return dp[costs.length][space];
    }


    /**
        对 solution 进行空间优化，使空间复杂度为O(space)
    */
    private static int solution2(int[] costs, int[] values, int space) {
        // dp[i] 表示容量为 i 时，所能选取的最大利润值
        int[] dp = new int[space + 1];

        /*
            // 这种写法得出的是完全背包问题的答案
            for(int i = costs[0]; i <= space; i++) {
                dp[i] = values[0];
            }

            for(int i = 1; i < costs.length; i++) {
                for(int j = costs[i]; j <= space; j++) {
                    dp[j] = Math.max(dp[j], dp[j - costs[i]] + values[i]);
                }
            }
        */

        for(int i = 0; i < costs.length; i++) {
            for(int j = space; j >= costs[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - costs[i]] + values[i]);
            }
        }

        return dp[space];
    }
}