import java.util.*;

/**
	网易笔试题 3
	有一个婚姻匹配系统，所有男生线登入系统，观看女生资料，然后再系统中登记他们自己有初步意向的女生，可以登记多个。
	反之女生也可以在系统中登记多个有初步意向的男生。如果某个女生和某个男生同时互相都有意向，则认定为匹配。
	最终系统会取出所有系统互相都初步匹配成功的男生女生，尽量地促成他们的真实约会，约会形式是互相匹配的一男与一女单独
	约会，但是被选中的男女省最多只能约会一次。问该系统最多能够促成多少次约会，让尽可能多的男女生得到约会机会。

	示例
	输入
	男生 id 0 1 2
	女生 id 3 4 5
	初步匹配关系
	0 4
	0 3
	1 3
	1 4
	2 5
	2 4

	核心思想：二分图的最大匹配问题（在保证每个顶点只会被使用一次的情况下，找到最多的边）
		1、匈牙利算法
*/
public class LoverMatch {
	private static boolean[] visited;
	private static int[] girl;
	private static int m = 3, w = 3;
	private static boolean[][] matchGraph = {
		{true, true, false},
		{true, true, false},
		{false, true, true},
	};
	
	public static void main(String[] args) {
		visited = new boolean[w];
		girl = new int[w];

		int matchCount = 0;
		for(int i = 0; i < m; i++) {
			Arrays.fill(visited, false);

			if(match(i)) {
				matchCount++;
			}
		}

		System.out.println(matchCount);

	}

	private static boolean match(int manId) {
		for(int j = 0; j < w; j++) {
			if(matchGraph[manId][j] && !visited[j]) {
				visited[j] = true;

				if(girl[j] == 0 || match(girl[j])) {
					girl[j] = manId;

					return true;
				}
			}
		}
		return false;
	}
}