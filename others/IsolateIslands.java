/**
	岛问题
	一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？
	举例：
	0 0 1 0 1 0
	1 1 1 0 1 0
	1 0 0 1 0 0
	0 0 0 0 0 0
	这个矩阵中有3个表
*/
public class IsolateIslands{
	public void solution(int[][] matrix){
		int M = matrix.length;
		int N = matrix[0].length;

		int count = 0;
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(matrix[i][j] == 1){
					count++;
					infect(matrix, i, j, N, M);
				}
			}
		}
	}

	public void infect(int[][] matrix, int i, int j, int width, int height){
		if(i < 0 || i >= width || j < 0 || j >= height || matrix[i][j] != 1){
			return;
		}

		matrix[i][j] = 2;

		// 上右下左
		infect(matrix, i - 1, j, width, height);
		infect(matrix, i, j + 1, width, height);
		infect(matrix, i + 1, j, width, height);
		infect(matrix, i, j - 1, width, height);
	}
}