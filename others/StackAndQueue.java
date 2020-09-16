import java.util.LinkedList;
import java.util.Stack;

/**
	如何仅用队列结构实现栈结构？
	如何仅用栈结构实现队列结构？
*/

public class StackAndQueue{
	/**
		队列实现栈
	*/
	private static class StackByTwoQueue{
		private LinkedList<Integer> data = new LinkedList<>();
		private LinkedList<Integer> help = new LinkedList<>();

		public void push(int ele){
			data.offer(ele);
		}

		public int pop(){
			if(data.isEmpty()){
				throw new RuntimeException("the stack is empty");
			}

			while(data.size() > 1){
				help.offer(data.poll());
			}
			int res = data.poll();

			// 数据栈和辅助栈相互交换
			swap();

			return res;
		}

		private void swap(){
			LinkedList<Integer> tmp = data;
			data = help;
			help = tmp;
		}
	}

	/**
		栈实现队列
	*/
	private static class QueueByTwoStack{
		private Stack<Integer> input = new Stack<>();
		private Stack<Integer> output = new Stack<>();

		public void offer(int ele){
			input.push(ele);
		}

		public int poll(){
			if(output.isEmpty()){
				while(!input.isEmpty()){
					output.push(input.pop());
				}
			}

			return output.pop();
		}
	}

	public static void main(String[] args){

	}
}