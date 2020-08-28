import java.util.PriorityQueue;

/**
    // leetcode 502 IPO
	cost = [50, 40, 20]
	profit = [10, 5, 10]
	invest = 20
	count = 2

	maxProfit = ?
*/
public class IPO{
	    static class CostProfit implements Comparable {
        private int cost;
        private int profit;

        CostProfit(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        @Override
        public int compareTo(Object o) {
            return cost - ((CostProfit) o).cost;
        }
    }

    public static void main(String[] args) {
        // 投资项目所需资金
        int[] cost = {100, 50, 70, 20};
        // 投资项目所获利润
        int[] profit = {15, 7, 5, 2};
        // 投资次数
        int count = 3;
        // 启动资金
        int invest = 40;

        // 小根堆,用来排序投资项目的花费
        PriorityQueue<CostProfit> smallRootHeap = new PriorityQueue<>(cost.length);
        // 大根堆，按利润大小来排序可以投资项目
        PriorityQueue<Integer> bigRootHeap = new PriorityQueue<>(profit.length, (Integer a, Integer b) -> b - a);

        for (int i = 0, len = cost.length; i < len; i++) {
            smallRootHeap.add(new CostProfit(cost[i], profit[i]));
        }

        for (int i = 0, len = smallRootHeap.size(); i < len; i++) {
            CostProfit cp = smallRootHeap.peek();
            // 将所有当前可以投资的项目按利润加到大根堆中
            if (cp.cost <= invest) {
                bigRootHeap.add(cp.profit);
                smallRootHeap.poll();
            }
        }

        int initialInvest = invest;
        while (bigRootHeap.size() > 0 && count > 0) {
            invest += bigRootHeap.poll();
            count--;

            for (int i = 0, len = smallRootHeap.size(); i < len; i++) {
                CostProfit cp = smallRootHeap.peek();
                if (cp.cost <= invest) {
                    bigRootHeap.add(cp.profit);
                    smallRootHeap.poll();
                } else {
                    break;
                }
            }
        }
        System.out.println("maxProfit = " + (invest - initialInvest));
    }
}