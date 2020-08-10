import java.util.Arrays;

/**
	插入排序：最佳时间复杂度O(n), 平均时间复杂度O(n^2)，额外空间复杂度O(1)
	插入排序是稳定的
	插入排序的改进就是：希尔排序，但希尔排序是不稳定的
*/
public class InsertSort {
	public static void main(String[] args) {
		int[] array = {3, 7, 1, 2, 5, 4, 8, 2, 0, 6};
		System.out.print("排序前的数组:");
		System.out.println(Arrays.toString(array));

		System.out.print("排序后的数组:");
		insertSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void insertSort(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}

		for(int i = 1; i < array.length; i++) {
			if(array[i] < array[i - 1]) {
				int coveredNum = array[i];
				int index = i - 1;
				while(index >= 0 && array[index] > coveredNum) {
					array[index + 1] = array[index];

					index--;
				}
				array[index + 1] = coveredNum;
			}
		}
	}
}