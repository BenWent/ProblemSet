import java.util.HashMap;
import java.util.Arrays;

/**
	给定一个包含 1 - n 的数列，通过交换任意两个元素给数列重新排序。求最少需要多少次交换，能把数组排成按 1 - n 递增的顺序（数组中的元素互不重复）。
	[3, 2, 1, 4]
	最少需要交换一次：将 3 和 1 交换一下就可以了
*/
public class SortArrayInLeastSwap {
	public static void main(String[] args) {
		int[] nums = {7, 5, 3, 2, 1, 4, 6};
	
		method1(nums);
		method2(nums);
	}

	private static void method2(int[] nums) {
		int[] sortedNums = new int[nums.length];
		System.arraycopy(nums, 0, sortedNums, 0, nums.length);
		Arrays.sort(sortedNums);

		int count = 0;
		for(int i = nums.length - 1, j = sortedNums.length - 1; i >= 0; i--) {
			if(nums[i] == sortedNums[j]) {
				count++;
				j--;
			}
		}
		System.out.println("交换次数:" + (nums.length - count));
	}

	private static void method1(int[] nums) {
		int[] copy = new int[nums.length];
		System.arraycopy(nums, 0, copy, 0, copy.length);
		Arrays.sort(copy);

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < copy.length; i++) {
			map.put(nums[i], i);
		}

		int loops = 0;
		boolean[] flags = new boolean[nums.length];
		for(int i = 0; i < copy.length; i++) {
			if(!flags[i]) {
				int j = i;

				while(!flags[j]) {
					flags[j] = true;
					j = map.get(copy[j]);
				}
				loops++;
			}
		}

		int count = nums.length - loops;

		System.out.println("交换次数:" + count);
	}
}