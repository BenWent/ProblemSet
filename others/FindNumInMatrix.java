/**
	在行列都排好序的矩阵中找数
		【题目】给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。
			实现一个函数，判断K是否在matrix中。
			例如：
				0 1 2 5 
				2 3 4 7
				4 4 4 8
				5 7 7 9
			如果K为7，返回true；如果K为6，返回false。
		【要求】时间复杂度为0（N+M），额外空间复杂度为0（1）。

		左神方法1
*/

import java.util.Scanner;

public class FindNumInMatrix{
	public static void main(String[] args){
		int[][] matrix = new int[][]{
			{0, 1, 2, 5},
			{2, 3, 4, 7},
			{4, 4, 4, 8},
			{5, 7, 7, 9}
		};

		System.out.println("矩阵为:");
		for(int[] array: matrix){
			for(int i: array){
				System.out.print(i + "\t");
			}
			System.out.println();
		}

		System.out.print("寻找数:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println("exists ? " + solution(matrix, num));
	}

	/**
		从最右上角元素为当前元素，记作matrix[r][c]
			1.matrix[r][c] > num,c只能左移(因为c列元素都比matrix[r][c]大，即比num大，所以r不能下移)
			2.matrix[r][c] < num,r只能下移(因为r行元素都比matrix[r][c]小，即比num小，所以c不能左移)
			3.matrix[r][c] = num,找到num

		选择最右上角的原因：该元素是该行最大，该列最小
	*/
	private static boolean solution(int[][] matrix, int num){
		int r = 0, c = matrix.length - 1;
		int n = matrix[0].length - 1;

		while(r <= n && 0 <= c){
			if(matrix[r][c] == num){
				return true;
			}

			if(matrix[r][c] < num){
				r++;
				// 指针下移(matrix[k][c]（k < r）< num)
			}else if(r <= n){
				c--;
				// 指针左移(matrix[r][k]（k > c）> num)
			}
		}

		return false;
	}
}