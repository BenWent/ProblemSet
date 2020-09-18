/**
	转圈打印矩阵
	【题目】给定一个整型矩阵matrix，请按照转圈的方式打印它。
	example:
		1	2	3	4
		5	6	7	8
		9	10	11	12
		13	14	15	16

	result：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10

	【要求】额外空间复杂度为0（1）。
*/
public class PrintMatrixInClockWise{
	private static final int MATRIX_SIZE = 10;
	public static void main(String[] args) {
		int[][] array = new int[MATRIX_SIZE][MATRIX_SIZE];

		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				array[i][j] = array.length * i + j;
			}
		}

		System.out.println("原矩阵:");
		for(int[] outer: array){
			for(int inner: outer){
				System.out.print(inner + "\t");
			}
			System.out.println();
		}

		System.out.println("结果为:");
		solution(array);
	}

	private static void solution(int[][] array){
		if(array == null || array.length == 0){
			return;
		}


		int top = 0, down = array.length - 1;
		int left = 0, right = array.length - 1;
		boolean leftToRight = true, topToDown = true;
		while(left <= right && top <= down){
			if(leftToRight){
				int tmp = left;
				while(tmp <= right){
					System.out.print(array[top][tmp++] + "\t");
				}
				
				top++;
			}else{
				int tmp = right;
				while(tmp >= left){
					System.out.print(array[down][tmp--] + "\t");
				}

				down--;
			}
			leftToRight = !leftToRight;
			System.out.println();

			if(topToDown){
				int tmp = top;
				while(tmp <= down){
					System.out.print(array[tmp++][right] + "\t");
				}

				right--;
			}else{
				int tmp = down;
				while(top <= tmp){
					System.out.print(array[tmp--][left] + "\t");
				}

				left++;
			}

			topToDown = !topToDown;
			System.out.println();
		}
	}
}