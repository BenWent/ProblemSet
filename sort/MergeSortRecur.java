import java.util.Arrays;

/**
	归并排序的递归版本
*/
public class MergeSortRecur {
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

		int[] copy = new int[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		mergeSortInner(copy, array, 0, array.length - 1);
	}

	private static void mergeSortInner(int[] array, int[] copy, int start, int end) {
		if(start == end) {
			return;
		}
		int mid = (start + end) >> 1;
		mergeSortInner(copy, array, start, mid);
		mergeSortInner(copy, array, mid + 1, end);

		int index = start;
		int rightStart = mid + 1;
		while(start <= mid && rightStart <= end) {
			if(array[start] > array[rightStart]) {
				copy[index++] = array[rightStart++];
			} else {
				copy[index++] = array[start++];
			}
		}
		while(start <= mid) {
			copy[index++] = array[start++];
		}
		while(rightStart <= end) {
			copy[index++] = array[rightStart++];
		}
	}
}
