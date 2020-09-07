import java.util.LinkedList;

/**
	树的序列化和反序列化
		1.先序
	举一反三：
		1.反序列化时，使用非递归方式实现
		2.中序、后序以及层序也能实现序列化和反序列化，你能通过代码实现吗？？
*/
public class SerialAndDeserialTree{
	private static class Node{
		public int value;
		public Node left, right;

		public Node(int value){
			this.value = value;
		}
	}

	public static String serialByPre(Node root){
		if(root == null){
			return "#!";
		}
		String res = root.value + "!";
		res += serialByPre(root.left);
		res += serialByPre(root.right);

		return res;
	}

	private static Node reconByPreString(String preStr){
		String[] values = preStr.split("!");
		LinkedList<String> queue = new LinkedList<>();

		for(String value: values){
			queue.offer(value);
		}

		return reconByPreQueue(queue);
	}

	private static Node reconByPreQueue(LinkedList<String> queue){
		// 当队列为空时，返回null，不会抛出异常.remove()方法在队列为空时，才会抛出 NoSuchElementException 异常
		String value = queue.poll();

		if(value.equals("#"))
			return null;

		Node node = new Node(Integer.valueOf(value));
		node.left = reconByPreQueue(queue);
		node.right = reconByPreQueue(queue);

		return node;
	}
}