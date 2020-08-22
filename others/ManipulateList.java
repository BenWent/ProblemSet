import java.util.Random;
import java.util.Arrays;

/**
	360 笔试第二题
	给定一个偶数长度的列表(1 - n)，有两种操作
	1. 将列表的第一个元素放到列表的尾部
	2. 将列表的第 1、2， 3、4，...，n-1、n 个元素互换

	如果使用数组来做只能过 55% 的用例
*/
public class ManipulateList {
	public static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int n = 6, m = 3;
		int[] actions = new int[m];

		Random r = new Random();
		for(int i = 0; i < m; i++) {
			actions[i] = r.nextInt(2) + 1;
		}

		// 要点：奇数与奇数之间的相对距离不会发生变化，偶数与偶数之间的相对距离不会发生变化
		Node oddHead = new Node(-1), evenHead = new Node(-1);
		Node oddTail = oddHead, evenTail = evenHead;
		for(int i = 1; i <= n; i++) {
			if((i & 1) == 1) {
				oddTail.next = new Node(i);
				oddTail = oddTail.next;
			} else {
				evenTail.next = new Node(i);
				evenTail = evenTail.next;
			}
		}

		boolean odd = true;
		for(int action: actions) {
			if(action == 1) {
				if(odd) {
					Node removedNode = oddHead.next;
					oddHead.next = removedNode.next;

					removedNode.next = null;
					oddTail.next = removedNode;
					oddTail = oddTail.next;
				} else {
					Node removedNode = evenHead.next;
					evenHead.next = removedNode.next;

					removedNode.next = null;
					evenTail.next = removedNode;
					evenTail = evenTail.next;
				}

			}

			odd = !odd;
		}

		System.out.println("操作为：" + Arrays.toString(actions));

		if(odd) {
			printTwoList(oddHead.next, evenHead.next);
		} else {
			printTwoList(evenHead.next, oddHead.next);
		}

	}

	private static void printTwoList(Node list1, Node list2) {
		while(list1 != null) {
			System.out.print(list1.val + " " + list2.val + " ");

			list1 = list1.next;
			list2 = list2.next;
		}
		System.out.println();
	}

}