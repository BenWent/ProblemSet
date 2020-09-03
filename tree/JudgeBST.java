import java.util.LinkedList;

/**
	判断一个树是否是搜索二叉树(通常搜索二叉树中不会出现重复结点；一个树的中序遍历是严格升序的，那么这个树是一颗搜索二叉树)
	判断一个树是否是完全二叉树（任何一个结点有右孩子，但没有左孩子，该树一定不是完全二叉树；）
*/
public class JudgeBST{
	private static Node{
		public int value;

		public Node left, right;

		public Node(int value){
			this.value = value;
		}
	}

	public static boolean isCBT(Node root){
		if(root == null){
			return true;
		}

		LinkedList<Node> queue = new LinkedList<>();
		boolean leaf = false;
		Node left = null, right = null;
		queue.offer(root);

		while(!queue.isEmpty()){
			Node node = queue.poll();
			left = node.left;
			right = node.right;

			if((leaf && (left != null || right != null)) || (left == null && right != null)){
				return false;
			}
			if(left != null){
				queue.offer(left);
			}
			if(right != null){
				queue.offer(right);
			}else{
				leaf = true;
			}
		}

		return true;
	}

}