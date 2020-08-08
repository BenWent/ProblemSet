import java.util.HashSet;

/**
	网易互联网 笔试题二
	给定长度为m的序列T，求一个长度为n且字典序最小的排列.并且要求序列T为所求排列的子序列.
*/
public class MinDicArrangement {
	public static void main(String[] args) {
		int[] T = {2, 1, 5};
		int n = 5;
		int[] remains = new int[n - T.length];

		HashSet<Integer> set = new HashSet<>();
		for(int i: T) {
			set.add(i);
		}
		for(int i = 1, j = 0; i <= n; i++) {
			if(!set.contains(i)) {
				remains[j++] = i;
			}
		}

		// 进行归并
		int i = 0, j = 0, index = 0;
		int[] res = new int[n];
		while(i < T.length && j < remains.length) {
			if(T[i] > remains[j]) {
				res[index++] = remains[j++];
			} else {
				res[index++] = T[i++];
			}
		}
		while(i < T.length) {
			res[index++] = T[i++];
		}
		while(j < remains.length) {
			res[index++] = remains[j];
		}

		for(int k = 0; k < res.length; k++) {
			System.out.print(res[k]);
			if(k != res.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}