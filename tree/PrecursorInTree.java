/**
	在二叉树中找到一个节点的后继节点
	【题目】现在有一种新的二叉树节点类型如下：
		public class Node{public int value；public Node left, right；public Node parent；public Node（int data）{this.value=data；}
		该结构比普通二又树节点结构多了一个指向父节点的parent指针。假设有一棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向自己
		的父节点，头节点的parent指向null。只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。在二叉树的中序遍历的序列中，node的下
		一个节点叫作node的后继节点。

	举一反三：找前驱结点?
*/
public class PrecursorInTree{
	private static class Node{
		public int value;
		public Node left, right;
		public Node parent;

		public Node(int data){
			this.value = data;
		}
	}

	public Node solution(Node root){
		if(root == null)
			return root;

		// 所给结点有右孩子，则后继结点为其右子树的最左一个结点
		if(root.right != null){
			Node node = root.right;
			while(node.left != null){
				node = node.left;
			}
			return node;
		}

		// 所给结点没有右结点，且为其父结点的左孩子，其后继结点为其父结点
		// 所给结点没有右结点，且为其父结点的右孩子，其后继结点为离该结点最近且作为左孩子结点的父结点

		// 归纳以上两点：所给结点没有右孩子，那么其后继结点为离该结点最近且作为左孩子结点的父结点
		Node parent = root.parent;
		while(parent != null && parent.left != root){
			root = parent;
			parent = parent.left;
		}

		return parent;
	}
}