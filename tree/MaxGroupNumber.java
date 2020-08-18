import java.util.List;

/**
	华为面试题 给定一个树最大能被划分为多少个组(每个分组只能是偶数个结点)
*/
public class MaxGroupNumber {
	public class TreeNode {
		List<TreeNode> children;
	}

	private int groupNumber = 0;

	private void solution(TreeNode root) {
		if(root == null) {
			System.out.println(0);
		}

		System.out.println((post(root) & 1) == 0 ? groupNumber : 0);
	}

	private int post(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int nodeCount = 1;
		for(TreeNode node: root.children) {
			nodeCount += post(node);
		}
		if((nodeCount & 1) == 0) {
			groupNumber++;
		}
		return nodeCount;
	}
}