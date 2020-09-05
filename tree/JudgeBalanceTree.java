import java.util.LinkedList;

/**
	如何判断一棵树是否是平衡二叉树

	思路：树形DP
*/
public class JudgeBalanceTree{
	private static class Node{
		public int value;

		public Node left, right;

		public Node(int value){
			this.value = value;
		}
	}

	/**
		1.左右子树都必须是平衡的
		2.求左右子树的高度差，高度差超过1，就表明该树不是平衡树
	*/
	public boolean isBalanceTree(Node root){
		if(root == null)	
			return true;
		if(!isBalanceTree(root.left)) return false;
		if(!isBalanceTree(root.right)) return false;

		return Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1;
	}


	/**
		利用层序遍历求树的最大深度（树高）
	*/
	private int treeHeight(Node root){
		if(root == null)
			return 0;

		LinkedList<Node> queue = new LinkedList<>();
		queue.offer(root);

		int height = 0;
		Node lastNode = root;
		while(!queue.isEmpty()){
			Node node = queue.poll();

			if(node.left != null){
				queue.offer(node.left);
			}

			if(node.right != null){
				queue.offer(node.right);
			}

			if(node == lastNode){
				height++;
				lastNode = queue.peekLast();
			}
		}

		return height + 1;
	}
}