import java.util.Arrays;

/**
	在一个int 数组里查找这样的数，它大于等于左侧所有数，小于等于右侧所有数。
*/
public class AllMidNumbers{
	public static void main(String[] args) throws Exception{
		int[] arr = {3, 2, 5, 6, 8, 9, 7};
		System.out.println("原数组：" + Arrays.toString(arr));
		int index = 0, num = -1;
		int[] rightMin = new int[arr.length];
		rightMin[arr.length - 1] = arr[arr.length - 1];
		for(int i = arr.length - 2; i >= 0; i--) {
			rightMin[i] = arr[i] > rightMin[i + 1] ? rightMin[i + 1] : arr[i];
		}

		System.out.println("满足要求的 <下标, 值>：");
		int leftMax = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(leftMax < arr[i]) {
				leftMax = arr[i];
			}

			if(leftMax <= arr[i] && arr[i] <= rightMin[i]) {
				System.out.println(String.format("<%d, %d>", i, arr[i]));
			}
		}
    }
}