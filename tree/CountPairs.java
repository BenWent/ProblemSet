/**
	LeetCode 第 199 周赛：
		5474.
		给你二叉树的根节点 root 和一个整数 distance 。
		如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
		返回树中 好叶子节点对的数量 

	思路来源于：https://www.cnblogs.com/a1439775520/p/13380192.html
*/
public class CountPairs {
	private class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	private int res;
	private int countParis(TreeNode root, int distance) {
		if(root == null || (root.left == null && root.right == null)) {
			return 0;
		}

		dfs(root, distance);

		return res;
	}

	/**
		@return root 的子结点到 root 的距离不大于 distance 的结点个数，即 dis[i] 表示到 root 结点的距离为 i 的子结点个数有 dis[i]
	*/
	private int[] dfs(TreeNode root, int distance) {
		if(root == null) {
			return new int[distance + 1];
		}

		int[] dis = new int[distance + 1];
		if(root.left == null && root.right == null) {
			dis[1] = 1;

			return dis;
		}

		// 到 root.left 距离不大于 distance 的结点个数
		int[] left = dfs(root.left);
		// 到 root.right 距离不大于 distance 的结点个数
		int[] right = dfs(root.right);

		// 两个叶子结点的距离为:两个叶子结点分别到根结点距离之和
		for(int i = 1; i <= distance; i++) {
			for(int j = 1; j <= distance - i; j++) {
				res += left[i] * right[j];
			}
		}

		// 到 root 距离不大于 distance 的结点个数
		for(int i = 2; i <= distance; i++) {
			dis[i] = left[i - 1] + right[i - 1];
		}

		return dis;
	}
}