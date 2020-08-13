/**
	给你一个二维数组，二维数组中的每个数都是正数，要求从左上角走到右下角，每一步只能向右或者向下。沿途经过的数字要累加起来。返回最小的路径和。

	所有的动态规划解法都是由暴力遍历优化得来
	1.在遍历过程中，对同一个输入做了多次求解
*/
public class LowestCostPath{

	private static int walk(int[][] matrix, int i, int j){
		if(i == matrix.length - 1 && j == matrix[0].length - 1){
			return matrix[i][j];
		}

		if(i == matrix.length - 1){
			return matrix[i][j] + walk(matrix, i, j + 1);
		}

		if(j == matrix[0].length - 1){
			return matrix[i][j] + walk(matrix, i + 1, j);
		}

		return matrix[i][j] + Math.min(walk(matrix, i, j + 1), walk(matrix, i + 1, j));
	}

	private static int dpWalk(int[][] matrix, int i, int j){
		int[][] dp = new int[matrix.length][matrix[0].length];

		int lastRow = matrix.length - 1, lastCol = matrix[0].length - 1;

		dp[lastRow][lastCol] = matrix[i][j];

		// 最后一列，只能往下行走
		for(int r = lastRow - 1; r >= 0; r--){
			dp[r][lastCol] = matrix[r][lastCol] + dp[r + 1][lastCol];
		}
		// 最后一行，只能往右行走
		for(int c = lastCol - 1; c >= 0; c--){
			dp[lastRow][c] = dp[lastRow][c] + dp[lastRow][c + 1];
		}

		// 倒推得出从 (0, 0) 到 (lastRow, lastCol) 的最佳
		for(int r = lastRow - 1; r >= 0; r--){
			for(int c = lastCol - 1; c >= 0; c--){
				dp[lastRow][lastCol] = matrix[i][j] + Math.min(dp[r + 1][c], dp[r][c + 1]);
			}
		}

		return dp[0][0];
	}
}