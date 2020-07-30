import java.util.stream.IntStream;
import java.util.stream.Collectors;

import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;

/**
	输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。
	--- 《剑指Offer》 38，拓展题
*/
public class CubeEightVertex{
	private static List<List<Integer>> res = new LinkedList<>();
	public static void main(String[] args) {
		int[] arr = IntStream.rangeClosed(1, 8).toArray();

		solution(arr, 0);

		System.out.println(res);
	}

	private static void solution(int[] arr, int index){
		if(index == arr.length - 1){
			int one = arr[0] + arr[1] + arr[2] + arr[3];
			int two = arr[4] + arr[5] + arr[6] + arr[7];
			int thr = arr[0] + arr[1] + arr[4] + arr[5];
			int fou = arr[2] + arr[3] + arr[6] + arr[7];
			int fiv = arr[1] + arr[2] + arr[5] + arr[6];
			int six = arr[0] + arr[3] + arr[4] + arr[7];

			if(one == two && thr == fou && fiv == six){
				res.add(IntStream.of(arr).boxed().collect(Collectors.toCollection(LinkedList<Integer>:: new)));
			}
		}

		HashSet<Integer> set = new HashSet<>();
		for(int i = index, len = arr.length; i < len; i++){
			if(!set.contains(arr[i])){
				set.add(arr[i]);
				swap(arr, i, index);
				solution(arr, index + 1);
				swap(arr, i, index);
			}
		}
	}

	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}