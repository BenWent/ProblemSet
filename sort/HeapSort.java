import java.util.Arrays;

/**
	堆排序：时间复杂度O(nlog(n))，额外空间复杂度O(1)
	堆结构非常重要
	1.堆结构的heap insert 与 heap heapfy
	2.堆结构的增大与减少
	3.如果只是建立堆的过程，时间复杂度为O(n)
	4.优先级队列结构就是堆结构
*/
public class HeapSort{
	public static void main(String[] args){
		int[] array = {3, 7, 1, 2, 5, 4, 8, 2, 0, 6};
		System.out.print("排序前的数组:");
		System.out.println(Arrays.toString(array));

		System.out.print("排序后的数组:");
		heapSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void heapSort(int[] array){
		if(array == null || array.length < 2){
			return;
		}

		buildHeap(array);
		for(int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			heapfy(array, 0, i);
		}
	}

	private static void buildHeap(int[] array) {
		for(int i = array.length >> 1; i >= 0; i--) {
			heapfy(array, i, array.length);
		}
	}

	private static void heapfy(int[] array, int parentIndex, int end) {
		int childIndex = 2 * parentIndex + 1;
		while(childIndex < end) {
			if((childIndex + 1) < end && array[childIndex + 1] > array[childIndex]) {
				childIndex = childIndex + 1;
			}

			if(array[childIndex] > array[parentIndex]) {
				swap(array, parentIndex, childIndex);

				parentIndex = childIndex;
				childIndex = 2 * parentIndex + 1;
			} else {
				break;
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}