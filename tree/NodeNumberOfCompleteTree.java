/**
	已知一棵完全二叉树，求其节点的个数要求：时间复杂度低于0（N），N为这棵树的节点个数
*/
public class NodeNumberOfCompleteTree{
	static class TreeNode {
		TreeNode left, right;
	}

	public static int nodeNum(TreeNode root){
		if(root == null) return 0;
		return bs(root, 1, mostLeftLevel(root, 1));
	}

	/**
		@param root 当前子树的根结点
		@param level 当前所在树的层级
		@param height 树的最大深度

		@return 以root为根结点的整棵树的结点个数
	*/
	private static int bs(TreeNode root, int level, int height){
		if(level == height)
			return 1;

		if(mostLeftLevel(root.right,level + 1) == height){
			// 说明 root.left 是一棵满二叉树
			return (1 << (height - level)) + bs(root.right, level + 1, height);
		}else{
			// 不能保证 root.left 是一个满二叉树，但可以保证 root 从 [level, high - 1] 是一棵满二叉树
			return (1 << (height - level - 1)) + bs(root.left, level + 1, height);
		}
	}

	private static int mostLeftLevel(TreeNode node, int level){
		while(node != null){
			level++;
			node = node.left;
		}

		return level - 1;
	}
}