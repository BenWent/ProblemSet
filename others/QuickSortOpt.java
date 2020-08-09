import java.util.Random;

/**
	快速排序，以及使用荷兰国旗问题的解法对其进行优化
	时间复杂度：O(nlog(n))，空间复杂度：O(log(n)) <== 在递归过程中需要开辟空间来记录 mid
		1.计算公式：T(N)=2T(N/2) + O(N)
	快速排序的问题在于：当待排序数组基本有序时，时间性能会恶化到O(n^2)，空间性能会恶化到O(n)

	对经典快速排序进行改进得到随机快速排序，这样能得到时间复杂度的长期期望为：O(nlog(n))
	随机快排是最常用的排序算法
*/
public class QuickSortOpt{
	public static final Random random = new Random();
	public static void main(String[] args){
		int[] array = Util.generateRandomIntArray(random.nextInt(20) + 1);
		System.out.print("排序前的数组:");
		Util.printIntArray(array);

		quickSort(array);
		System.out.print("排序后的数组:");
		Util.printIntArray(array);
	}

	public static void quickSort(int[] array){
		if(array == null || array.length <= 1){
			return;
		}

		quickSortInnerOpt(array, 0, array.length - 1);
	}

	private static void quickSortInnerOpt(int[] array, int start, int end){
		if(start < end){
			// 随机快速排序的关键代码（注释这行代码就变成了经典快速排序）
			// 不同于经典快速排序总是选择第一个元素作为pivot，随机快速排序将随机选择一个元素作为pivot
			// 加入[start, end]区间的数为[1, 2, 3, 4]，随机快排的策略为：
			// 数组可能变为[3, 2, 1, 4]，快速排序完后，将变成 [2, 1, 3, 4] ==> 将数组一分为二
			// 而不是经典排序的[1, 2, 3, 4]数组并没有一分为二
			Util.swapInt(array, start + (int)(Math.random() * (end - start + 1)), start);

			int[] mids = partitionOpt(array, start, end);
			quickSortInner(array, start, mids[0] - 1);
			quickSortInner(array, mids[1] + 1, end);
		}
	}

	/**
		使用荷兰国旗问题的解法对分区算法进行优化
		优化点在于：当待排序数组中有大量相同元素时，可以减少划分分区的次数
	*/
	private static int[] partitionOpt(int[] array, int start, int end){
		int pivot = array[start];
		int smallerArrayRight = start - 1, largerArrayLeft = end + 1;
		while(start < largerArrayLeft){
			if(pivot > array[start]){
				Util.swapInt(array, start++, ++smallerArrayRight);
			}else if(pivot < array[start]){
				Util.swapInt(array, start, --largerArrayLeft);
			}else{
				start++;
			}
		}
		// 划分元素组成集合中，最左边以及最右边划分元素的索引
		return new int[]{smallerArrayRight + 1, largerArrayLeft - 1};
	}

	private static void quickSortInner(int[] array, int start, int end){
		if(start < end){
			int mid = partition(array, start, end);
			quickSortInner(array, start, mid - 1);
			quickSortInner(array, mid + 1, end);
		}
	}

	/**
		进行分区，分区的结果为：左区的元素都比array[start]小，右区的元素都比array[start]大
	*/
	private static int partition(int[] array, int start, int end){
		int pivot = array[start];
		while(start != end){
			// 应该先与后面的比较后，再与前面的比较，这样才能将pivot放到后面
			while(start < end && array[end] >= pivot) end--;
			Util.swapInt(array, end, start);

			while(start < end && array[start] <= pivot) start++;
			Util.swapInt(array, end, start);
		}

		return start;
	}
}