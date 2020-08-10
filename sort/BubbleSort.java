import java.util.Arrays;

/**
	插入排序：平均时间复杂度O(n^2)，额外空间复杂度O(1)
*/
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {3, 7, 1, 2, 5, 4, 8, 2, 0, 6};
		System.out.print("排序前的数组:");
		System.out.println(Arrays.toString(array));

		System.out.print("排序后的数组:");
		bubbleSortOpt3(array);
		System.out.println(Arrays.toString(array));
	}

	private static void bubbleSort(int[] array) {
		if(array == null || array.length < 2) {
			return;
		}
		for(int i = 0; i < array.length; i++) {
			for(int j = 0, end = array.length - i - 1; j < end; j++) {
				if(array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	private static void bubbleSortOpt(int[] array) {
		if(array == null || array.length < 2) {
			return;
		}

		for(int i = 0; i < array.length; i++) {
			boolean sort = true;
			for(int j = 0, end = array.length - i - 1; j < end; j++) {
				if(array[j] > array[j + 1]) {
					swap(array, j, j + 1);

					sort = false;
				}
			}
			if(sort) {
				break;
			}
		}
	}

	private static void bubbleSortOpt2(int[] array) {
		if(array == null || array.length < 2) {
			return;
		}

		int lastExchangeIndex = array.length - 1, bound;
		while(lastExchangeIndex != 0) {
			bound = lastExchangeIndex;
			lastExchangeIndex = 0;
			for(int i = 0; i < bound; i++) {
				if(array[i] > array[i + 1]) {
					lastExchangeIndex = i;

					swap(array, i, i + 1);
				}
			}
		}
	}

	/**
		二元冒泡排序
	*/
	private static void bubbleSortOpt3(int[] array) {
		if(array == null || array.length < 2) {
			return;
		}

		int left = 0, right = array.length - 1;
		while(left < right) {
			for(int i = left; i < right; i++) {
				if(array[i] > array[i + 1]) {
					swap(array, i, i + 1);
				}
			}
			right--;

			for(int i = right; i > left; i--) {
				if(array[i] < array[i - 1]) {
					swap(array, i, i - 1);
				}
			}

			left++;
		}
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}