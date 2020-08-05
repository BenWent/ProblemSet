import java.util.*;

/**
	打印出给定序列的所有出栈顺序
	打印的个数满足卡特兰数：h(n)=C(2n,n)/(n+1)
*/
public class AllPosibilitiesByStack{
	static List<List<Integer>> res = new LinkedList<>();

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4};

		core(input, 0, new LinkedList<Integer>(), new ArrayDeque<Integer>());
		System.out.println(res);
	}

	/**
		@param input 入栈序列
		@param index 第 index 个元素入栈
		@param list  出栈序列
		@param stack 辅助栈
	*/
	private static void core(int[] input, int index, LinkedList<Integer> list, Deque<Integer> stack){
		if(index == input.length){
			// 最后一个元素入栈

			if(!stack.isEmpty()){
				int peek = stack.pop();
				list.add(peek);

				core(input, index, list, stack);

				// 回溯
				stack.push(peek);
				list.pollLast();
			} else {
				res.add(new LinkedList<>(list));
			}
		} else {
			// 第 index 个元素入栈
			stack.push(input[index]);
			core(input, index + 1, list, stack);
			stack.pop();

			if(!stack.isEmpty()){
				// 第 index - 1 个元素出栈，先于后面的 (n - index + 1) 个元素入栈
				int peek = stack.pop();
				list.add(peek);

				core(input, index, list, stack);

				// 回溯
				stack.push(peek);
				list.pollLast();

				// System.out.println(stack);
			}
		}

	}
}
