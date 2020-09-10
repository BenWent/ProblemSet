import java.util.HashMap;

/**
	复制含有随机指针节点的链表
	【题目】一种特殊的链表节点类描述如下：
	public class Node{public int value；public Node next；public Node rand；public Node（int data）{this.value=data；}
	Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向下一个节点，
	rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个节点，也可能指向null。
	给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。

	【进阶】
	不使用额外的数据结构，只用有限几个变量，且在时间复杂度为0（N）完成原问题要实现的函数。
*/
public class CopyList{
	private static class Node{
		public int value;
		public Node next;
		public Node rand;

		public Node(int value){
			this.value = value;
		}
	}

	/**
		将就结点与新拷贝的结点一一对应起来
	*/
	public static Node solution(Node head){
		HashMap<Node, Node> map = new HashMap<>();

		Node tmp = head;
		while(tmp != null){
			map.put(tmp, new Node(tmp.value));

			tmp = tmp.next;
		}

		tmp = head;
		while(tmp != null){
			Node node = map.get(tmp);
			node.next = map.get(tmp.next);
			node.rand = map.get(tmp.rand);

			tmp = tmp.next;
		}

		return map.get(head);
	}

	/**
		不引入额外的数据结构。
		原来的链表:1 -> 2 -> 3
		1.在旧链表基础上构建一个新链表： 1 -> 1' -> 2 -> 2' -> 3 -> 3'
		2.从这个链表中，我们可以推断出：1'的rand为1的rand的next结点
		3.将x结点与x'结点分离成两个链表
	*/
	public static Node solutionAdv(Node head){
		Node tmp = head;
		while(tmp != null){
			Node node = new Node(head.value);
			node.next = tmp.next;
			tmp.next = node;

			tmp = tmp.next.next;
		}

		// 设置rand
		tmp = head;
		while(tmp != null){
			Node copyNode = tmp.next;
			Node randNode = tmp.rand;
			copyNode.rand = randNode == null ? null : randNode.next;

			tmp = tmp.next.next;
		}

		// 分离链表
		tmp = head;
		Node newHead = head.next;
		Node node = newHead;
		while(tmp != null){
			tmp.next = node.next;
			node.next = node.next != null ? node.next.next : null;

			tmp = tmp.next;
			node = node.next;
		}

		return newHead;
	}
}