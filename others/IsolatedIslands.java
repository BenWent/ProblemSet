/**
	给定一个二维数组，求相邻 1 的分组中，拥有最大 1 的分组的元素个数
*/
public class IsolatedIslands {
	public static void main(String[] args) {
		int[][] arr = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}};

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    res = Math.max(res, dfs(arr, i, j, 0));
                }
            }
        }
        System.out.println(res);
	}

	private static int dfs(int[][] arr, int i, int j, int count) {
        if (i < 0 || i == arr.length) {
            return count;
        }
        if (j < 0 || j == arr[i].length || arr[i][j] != 1) {
            return count;
        }

        arr[i][j] = Integer.MAX_VALUE;
        count++;

        int top = dfs(arr, i - 1, j, count);
        int down = dfs(arr, i + 1, j, count);
        int left = dfs(arr, i, j - 1, count);
        int right = dfs(arr, i, j + 1, count);

        arr[i][j] = 1;

        return Math.max(Math.max(top, down), Math.max(left, right));
    }
}