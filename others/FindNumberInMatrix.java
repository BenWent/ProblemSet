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

		自定义解法
*/

import java.util.Scanner;

public class FindNumberInMatrix{
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
		主要是对边界进行判断
	*/
	private static boolean solution(int[][] matrix, int num){
		for(int i = 0; i < matrix.length; i++){
			int lastIndex;
			int start = matrix[i][0], end = matrix[i][(lastIndex = matrix[i].length - 1)];

			if(num == start || num == end){
				return true;
			}

			if(num < start){
				return false;
			}

			if(num < end){
				for(int j = 1; j < lastIndex; j++){
					if(matrix[i][j] == num)
						return true;
				}
			}
		}
		return false;
	}
}