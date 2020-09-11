import java.util.Stack;

/**
	判断一个链表是否为回文结构
	【题目】给定一个链表的头节点head，请判断该链表是否为回文结构。例如：1->2->1，返回true。1->2->2->1，返回true。
	15->6->15，返回true。1->2->3，返回false。

	【进阶】：如果链表长度为N，时间复杂度达到0（N），额外空间复杂度达到0（1）。
*/
public class CircleInList{
	private static class Node{
		int value;
		Node next;
	}
	public static void main(String[] args){

	}

	/**
		思想：快慢指针

		为什么快慢指针能够相遇就能证明链表中存在环？
			这个问题你可以用数学归纳法来思考。
			首先，由于链表是个环，所以相遇的过程可以看作是快指针从后边追赶慢指针的过程。
			那么做如下思考：
				1、快指针与慢指针之间差一步。此时继续往后走，慢指针前进一步，快指针前进两步，两者相遇；
				2、快指针与慢指针之间差两步。此时唏嘘往后走，慢指针前进一步，快指针前进两步，两者之间相差一步，转化为第一种情况；
				3、快指针与慢指针之间差N步。此时继续往后走，慢指针前进一步，快指针前进两步，两者之间相差(N+1-2)-> N-1步。
			因此，此题得证。所以快指针必然与慢指针相遇。又因为快指针速度是慢指针的两倍，所以相遇时必然只绕了一圈。
	*/
	public boolean solution(Node head){
		if(head == null || head.next == null || head.next.next == null){
			return false;
		}

		Node faster = head.next.next, slower = head.next;

		// 如果该链表是个整环，那么快慢指针一定在起始点相遇
		/**
			证明：
				假设环长度为n
				起始时，快慢指针相距0步，它们共向后移动m次后，快指针就比慢指针多m步
				m = n时，快慢指针相距n步（因为是圆，相当于回到起点），所以此时快慢指针相距0步
				=============================下面的正面更容易让人理解========================

				1.m为起点到快慢指针相遇点的距离(m <= len)；
				2.len为环的长度，
				则有一下公式成立
				2 * m = k * len + m <== 快指针转了k(k取整数)圈后，与慢指针在距离起点m处相遇
				m = k * len，所以k只能取1
				即快慢指针一定在环中运行时一定在起点处
		*/
		while(faster != slower){
			if(faster.next == null || faster.next.next == null){
				return false;
			}

			faster = faster.next.next;
			slower = slower.next;
		}

		return faster == head;
	}
}