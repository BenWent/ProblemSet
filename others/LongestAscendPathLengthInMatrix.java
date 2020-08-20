/**
	商汤笔试 2（leetcode 329） 给出一个数字矩阵，寻找一条最长上升路径，每个位置只能向上下左右四个位置移动。
	如，nums = [[9, 1, 4], [6, 2, 8], [5, 5, 7]] 返回 5，即最长上升路径为 [1, 2, 5, 7, 8]

	leetcode 困难题，我竟然做出来了！
*/
public class LongestAscendPathLengthInMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
			{9, 1, 4},
			{6, 2, 8},
			{5, 5, 7}
		};

		int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, Integer.MIN_VALUE, 0));
            }
        }

        System.out.println(res);
	}

	private static int dfs(int[][] arr, int i, int j, int pre, int count) {
        if(i < 0 || j < 0 || i == arr.length || j == arr[i].length || pre >= arr[i][j]) {
            return count;
        }
        count++;

        pre = arr[i][j];
        int a = dfs(arr, i - 1, j, pre, count);
        int b = dfs(arr, i + 1, j, pre, count);
        int c = dfs(arr, i, j - 1, pre, count);
        int d = dfs(arr, i, j + 1, pre, count);

        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}