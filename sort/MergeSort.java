import java.util.Arrays;

/**
	归并排序：时间复杂度O(nlog(n))，额外空间复杂度O(n)
	归并非常重要：归并排序是稳定的排序，可以用在多种场合
		1. 	剑指 Offer 51 ：数组中的逆序对
		2. 2021年网易互联网正式批校招笔试题二：给定长度为m的序列T，求一个长度为n且字典序最小的排列.并且要求序列T为所求排列的子序列.
*/
public class MergeSort {
	public static void main(String[] args) {
		int[] array = {3, 7, 1, 2, 5, 4, 8, 2, 0, 6};
		System.out.print("排序前的数组:");
		System.out.println(Arrays.toString(array));

		System.out.print("排序后的数组:");
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int[] array) {
		if(array == null || array.length < 2) {
			return;
		}

		int len = 1;
		int[] copy = new int[array.length];
		while(len < array.length) {
			mergeSortInner(array, copy, len);
			len <<= 1;

			mergeSortInner(copy, array, len);
			len <<= 1;
		}
	}

	private static void mergeSortInner(int[] array, int[] copy, int len) {
		int index = 0, last = array.length - 2 * len;
		while(index < last) {
			merge(array, copy, index, index + len, index + len, index + 2 * len);

			index += 2 * len;
		}

		if(index < array.length - len) {
			merge(array, copy, index, index + len, index + len, array.length);
		} else {
			while(index < array.length) {
				copy[index] = array[index++];
			}
		}
	}

	private static void merge(int[] array, int[] copy, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int index = leftStart;
		while(leftStart < leftEnd && rightStart < rightEnd) {
			if(array[leftStart] > array[rightStart]) {
				copy[index++] = array[rightStart++];
			} else {
				copy[index++] = array[leftStart++];
			}
		}

		while(leftStart < leftEnd) {
			copy[index++] = array[leftStart++];
		}
		while(rightStart < rightEnd) {
			copy[index++] = array[rightStart++];
		}
	}
}