public class MatrixReverse{
	public static void main(String ... args){
		int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int n = mat.length;
        // 群论知识：旋转九十度可以进行分解为两个对称操作

        // 先按对角线翻转
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

        // 再按中轴线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = mat[i][(n-1) - j];
                mat[i][(n-1) - j] = mat[i][j];
                mat[i][j] = tmp;
            }
        }

        for(int[] is: mat){
        	for(int i: is){
        		System.out.print(i + " ");
        	}
        	System.out.println();
        }
	}
}