import java.util.PriorityQueue;
import java.util.Arrays;


/**
    老虎集团 笔试题一

    一条单向路线上有最多 1000 个站点，车辆按站点从小到大的顺序行驶，有一批旅客从不同的站点上下车，你负责给这批旅客安排车辆，
    假设每辆车的载客量为 capacity，求最少需要多少辆车？

    输入参数
    1.trips：二维 int 数组，用于表示一组乘客的行程信息，其中 trips[i] 表示第 i 组乘客，trips[i]][0] 表示第组乘客的乘客数量，
        trips[i]][1] 表示上车站点，trips[i][2] 表示下车站点。
    2.capacity:int 类型，表示每辆车最多能承载多少名乘客输入参数满足下列条件
        trips.length <= 1000
        trips[i].length == 3
        1 <= trips[i][0] <= 100
        0 <= trips[i][1] < trips[i][2] <=1000
        1 <= capacity <= 100000
*/
public class ArrangeLeastBus {
    class Node implements Comparable<Node>{
        int num;
        int start, end;
        
        Node(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Node n2) {
            return start == n2.start ? end - n2.end : start - n2.start;
        }
    }

    /**
     *  自己的 AC 思路
     */
    public int minCarCount(int[][] trips, int capacity) {
        Node[] nodes = new Node[trips.length];
        for(int i = 0; i < trips.length; i++) {
            nodes[i] = new Node(trips[i][0], trips[i][1], trips[i][2]);
        }
        Arrays.sort(nodes);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int count = 0;
        int used = 0;
        for(Node node: nodes) {
            Node top = queue.peek();
            if(queue.isEmpty() || (top.end > node.start && node.end > top.start)) {
                queue.offer(node);
            } else {
                Node deletedNode = queue.poll();
                used -= deletedNode.num;
                queue.offer(node);
            }
            
            used += node.num;
            while(used > (count * capacity)) {
                count++;
            }
        }
        
        return count;
    }

    /**
        网友的 AC 逻辑
    */
    public int minCarCountOpt(int[][] trips, int capacity) {
        // terminals[i] 表示在第 i 个车站有 terminals[i] 人需要乘车
        int[] terminals = new int[1001];

        for(int[] trip: trips) {
            for(int i = trip[1], num = trip[0]; i <= trip[2]; i++) {
                terminals[i] += num;
            }
        }

        // 找到最拥塞车站的拥塞人数
        int max = 0;
        for(int terminal: terminals) {
            max = Math.max(terminal, max);
        }

        return max / capacity + (max % capacity == 0 ? 0 : 1);
    }
}