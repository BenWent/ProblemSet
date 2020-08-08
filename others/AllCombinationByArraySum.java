import java.util.Random;
import java.util.LinkedList;

/**
	求一个数组中和为sum的所有组合
*/
public class AllCombinationByArraySum {
	// private static final Random R = new Random();

	public static void main(String[] args){
		int[] arr = new int[]{3, 7, 6, 8, 4, 5};
		// for(int i = 0; i < arr.length; i++){
		// 	arr[i] = R.nextInt(50);
		// }
		int target = 13;

		LinkedList<LinkedList<Integer>> result = new LinkedList<>();
		solution(arr, 0, 0, target, result, new LinkedList<Integer>());
		for(LinkedList<Integer> list: result){
			for(Integer i: list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	/**
		元素只能使用一次
	*/
	private static void solution(int[] arr, int i, int sum, int target, LinkedList<LinkedList<Integer>> result,
		LinkedList<Integer> help){

		if(i == arr.length){
			return;
		}

		if(target >= arr[i]){
			// 防止添加重复的组合
			boolean add = true;
			for(LinkedList<Integer> l: result){
				if(l.size() == 1 && l.contains(target)){
					add = false;

					break;
				}
			}

			if(add){
				LinkedList<Integer> list = new LinkedList<>();
				list.add(target);
				result.add(list);
			}
		}

		if(sum <= target){
			// 防止添加重复的组合
			boolean add = true;
			LinkedList<Integer> list = new LinkedList<>();
			for(int j = 0, len = help.size(); j < len; j++){
				list.add(help.get(j));
			}

			for(LinkedList<Integer> l: result){
				if(l.equals(list)){
					add = false;

					break;
				}
			}

			if(add)
				result.add(list);
		}

		help.add(arr[i]);
		solution(arr, i + 1, sum + arr[i], target, result, help);
		help.removeLast();
		solution(arr, i + 1, sum, target, result, help);
	}

	/**
		元素可以多次使用
	*/
	private static void solution2(int[] arr, int target, LinkedList<LinkedList<Integer>> result, LinkedList<Integer> help){
		if(target == 0){
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 0, len = help.size(); i < len; i++){
				list.add(help.get(i));
			}
			result.add(list);
		}

		if(target > 0){
			for(int i = 0; i < arr.length; i++){
				help.add(arr[i]);
				solution2(arr, target - arr[i], result, help);
			}
		}

		if(!help.isEmpty()){
			help.removeLast();
		}
	}
}