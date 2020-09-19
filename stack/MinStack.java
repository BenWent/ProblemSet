/**
	实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
	【要求】
	1.pop、push、getMin操作的时间复杂度都是0（1）。
	2.设计的栈类型可以使用现成的栈结构。
*/
public class MinStack{
	/**
		实现一个环形栈
	*/
	private static class MyStack{
		private int first = 0, last = 0;
		private final int DEFAULT_CAPABILITY = 20;
		private int[] array = new int[DEFAULT_CAPABILITY];

		public void push(int ele){
			int index = (first + 1) % array.length;
			if(index == last){
				throw new RuntimeException("the stack is full");
			}

			array[index] = ele;
			first = (first + 1) % array.length;
		}

		public int pop(){
			if(last == first){
				throw new RuntimeException("the stack is empty");
			}

			int res = array[last];
			last = (last + 1) % array.length;

			return res;
		}

		public int peek(){
			if(isEmpty()){
				throw new RuntimeException("the stack is empty");
			}

			return array[first];
		}

		public boolean isEmpty(){
			return first == last;
		}
	}

	private static class MyMinStack{
		// 正常栈
		MyStack stack1 = new MyStack();
		// 栈顶元素为stack1中所有元素中最小的那个元素
		MyStack stack2 = new MyStack();

		public void push(int ele){
			stack1.push(ele);

			if(stack2.isEmpty()){
				stack2.push(ele);
			}else{
				if(stack2.peek() >= ele){
					stack2.push(ele);
				}else{
					stack2.push(stack2.peek());
				}
			}
		}

		private int pop(){
			stack2.pop();
			return stack1.pop();
		}

		public int getMin(){
			return stack2.peek();
		}
	}

	public static void main(String[] args){
		int[] array = Util.generateRandomIntArray((int)(Math.random() * 20 + 1));
		System.out.print("进栈顺序:");
		Util.printIntArray(array);

		MyMinStack minStack = new MyMinStack();
		for(int i: array){
			minStack.push(i);
			System.out.println("当前最小元素为:" + minStack.getMin());
		}
	}
}