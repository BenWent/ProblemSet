import java.util.List;
import java.util.LinkedList;

public class Subsequence{
	private static List<String> list = new LinkedList<>();

	public static void main(String[] args){
		permutation("abc".toCharArray(), 0);
		System.out.println(list);
	}

	/**
		求数组所有排列
	*/
	private static void permutation(char[] arr, int index){
		if(index == arr.length - 1){
			list.add(String.valueOf(arr));
		}
		for(int i = index; i < arr.length; i++){
			swap(arr, index, i);
			permutation(arr, index + 1);
			swap(arr, index, i);
		}
	}

	private static void swap(char[] arr, int i, int j){
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}


	/**
		求数组所有连续的序列
	*/
	private static void allSuccessiveSubSequence(char[] arr){
		/**
			时间复杂度O (n^3)
		*/
		for(int i = 0; i < arr.length; i++){
			for(int j = i; j < arr.length; j++){
				StringBuilder sb = new StringBuilder();
				for(int k = i; k <= j; k++){
					sb.append(arr[k]);
				}
				list.add(sb.toString());
			}
		}

	}

	/**
		求数组的所有子序列
	*/
	private static void allSubSequence(char[] arr, int index, String s){
		if(index == arr.length){
			list.add(s);

			return;
		}
		allSubSequence(arr, index + 1, s + arr[index]);
		allSubSequence(arr, index + 1, s);
	}

	/**
		求长度为 n 的字符串，所有长度为 len 的子串的组合
		--- 《剑指offer》 38 题扩展
	*/
	private static void subsequence(char[] arr, int index, int len, String s){
		if(len == 0){
			list.add(s);
		}

		// n = arr.length
		if(index == arr.length){
			return;
		}

		// 如果添加了当前字符，则从剩下的 n - 1 个字符中选择 m - 1 个字符
		subsequence(arr, index + 1, len - 1, s + arr[index]);
		// 如果没有添加当前字符，则从剩下的 n - 1 个字符中选择 m 个字符
		if(len != 0){
			subsequence(arr, index + 1, len, s);
		}
	}
}