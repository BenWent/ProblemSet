import java.util.*;

/**
	给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数。如何实现？
*/
public class ReverseStack{
	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println("反转前的栈 :" + stack);
		reverseStack(stack);

		System.out.println("反转后的栈 :"+ stack);
	}

	public static void reverseStack(Deque<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int buttomElement = getButtomElement(stack);
		reverseStack(stack);
		stack.push(buttomElement);
	}

	private static int getButtomElement(Deque<Integer> stack) {
		int top = stack.pop();
		if(stack.isEmpty()) {
			return top;
		} else {
			int res = getButtomElement(stack);
			stack.push(top);
			return res;
		}
	}
}