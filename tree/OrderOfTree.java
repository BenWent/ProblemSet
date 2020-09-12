import java.util.Stack;
import java.util.LinkedList;

public class OrderOfTree{
	private static class TreeNode{
		public int value;
		public TreeNode left, right;

		// 用于后序遍历
		public boolean visited;
	}

	private static void preOrderRecur(TreeNode root){
		if(root == null){
			return;
		}

		System.out.println(root.value);
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}

	private static void preOrder(TreeNode root){
		if(root == null){
			return;
		}

		Stack<TreeNode> stack = new Stack<>(); 
		stack.push(root);

		while(root != null || !stack.isEmpty()){
			while(root != null){
				System.out.println(root.value);
				stack.push(root);
				root = root.left;
			}

			if(!stack.isEmpty()){
				TreeNode node = stack.pop() ;
				root = node.right;
			}
		}
	}

	private static void middleOrderRecur(TreeNode root){
		if(root == null){
			return;
		}

		middleOrderRecur(root.left);
		System.out.println(root.value);
		middleOrderRecur(root.right);
	}

	private static void middleOrder(TreeNode root){
		if(root == null){
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}

			if(!stack.isEmpty()){
				TreeNode node = stack.pop();
				System.out.println(node.value);
				root = node.right;
			}
		}
	}

	private static void postOrderRecur(TreeNode root){
		if(root == null){
			return;
		}

		postOrderRecur(root.left);
		postOrderRecur(root.right);
		System.out.println(root.value);
	}

	private static void postOrder(TreeNode root){
		if(root == null){
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}

			while(!stack.isEmpty() && stack.peek().visited){
				System.out.println(stack.pop().value);
			}

			if(!stack.isEmpty()){
				stack.peek().visited = true;
				TreeNode right = stack.peek().right;
			}
		}
	}

	private static void postOrderWithoutFlag(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		stack1.push(root);
		while(!stack1.isEmpty()){
			TreeNode node = stack1.pop();
			stack2.push(node);
			if(node.left != null){
				stack1.push(node.left);
			}

			if(node.right != null){
				stack1.push(node.right);
			}
		}

		while(!stack2.isEmpty()){
			TreeNode node = stack2.pop();
			System.out.println(node.value);
		}
	}

	private static void levelOrder(TreeNode root){
		if(root == null)
			return;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.println(node.value);

			if(node.left != null){
				queue.offer(node.left);
			}

			if(node.right != null){
				queue.offer(node.right);
			}
		}
	}

	private static void levelOrder2(TreeNode root) {
		if(root == null) {
			return;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int num;
		while((num = queue.size()) != 0) {
			for(int i = 0; i < num; i++) {
				TreeNode node = queue.poll();
				System.out.println(node.value);

				if(node.left != null){
					queue.offer(node.left);
				}

				if(node.right != null){
					queue.offer(node.right);
				}
			}
		}
	}
}