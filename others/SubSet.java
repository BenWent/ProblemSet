import java.util.List;
import java.util.ArrayList;

/**
	leetcode 78 求数组的所有子集
	[1, 2, 3] 的子集有：
	[]、[1]、[2]、[3]、[1, 2]、[1, 3]、[2, 3]、[1, 2, 3]
*/
public class SubSet {
	public static void main(String[] args) {
		int n = 3;
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		List<List<Integer>> res = new ArrayList<>();
		/**
			集合nums的幂集的元素个数(2^n)
			二进制的第i位取1代表取数组的第 i 个元素，第i位取0代表不取数组的第 i 个元素
			对于数组 [1, 2, 3]，001 代表 [1]，101 代表[1, 3]，...
		*/
		for(int i = 0, len = nums.length, total = 1 << len; i < total; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = 0; j < len; j++) {
				if((i & (1 << j)) != 0) {
					list.add(nums[j]);
				}
			}
			res.add(list);
		}
		System.out.println(res);
	}
}