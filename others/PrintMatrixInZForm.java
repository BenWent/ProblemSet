/**
	“之”字形打印矩阵
	【题目】给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵
	例如：
		1	2	3	4
		5	6	7	8
		9	10	11	12
		13	14	15	16
	打印结果为：1,2,5,9,6,3,4,7,10,13,14,11,8,12,15,16
	【要求】额外空间复杂度为0（1）。
*/
public class PrintMatrixInZForm{
	private static final int SIZE = 10;

	public static void main(String[] args){
		int[][] matrix = new int[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++){
			for(int j = 1; j <= SIZE; j++){
				matrix[i][j - 1] = 5 * i + j;
			}
		}

		System.out.println("矩阵为:");
		for(int[] array: matrix){
			for(int i: array){
				System.out.print(i + "\t");
			}
			System.out.println();
		}

		System.out.println("\n打印结果为:");
		printMatrixInZForm(matrix);
	}

	/**
		思路：使用两个指针a，b；
			1.a朝右走，走到底后，往下走；
			2.b朝下走，走到底后，往右走。
	*/
	private static void printMatrixInZForm(int[][] matrix){
		if(matrix == null)
			return;

		// 点(tr, tc)与点(dr, dc)连接起来的直线上的所有点即为此次要打印的元素
		int tr = 0, tc = 0, dr = 0, dc = 0;
		int endR = matrix.length, boundary = endR - 1;
		boolean upperRight = true;

		// 终止条件为点(tr, tc)运动到了(matrix[size - 1], matrix[size -1])处
		// 由于存在一个限制因素，即tr先运动,tc后运动，所以tc到达了size-1处，tr也一定到达了size-1处
		while(tr != endR){
			print(matrix, tr, tc, dr, dc, upperRight);

			if(tc != boundary){
				// 第一个指针先向右移动
				tc++;
			}else{
				// 第一个指针再向下移动
				tr++;
			}

			if(dr != boundary){
				// 第二个指针先向下移动
				dr++;
			}else{
				// 第二个指针再向右移动
				dc++;
			}

			upperRight = !upperRight;
		}
		
	}

	/**
		打印点(tr, tc)与点(dr, dc)所确定直线上的所有点
		@param upperRight 以哪个方向进行打印，true代表以右上方为打印方向；false代表以左下方为打印方向
	*/
	private static void print(int[][] matrix , int tr, int tc, int dr, int dc, boolean upperRight){
		if(upperRight){
			// 打印终止的条件为：左下方的点沿直线运动到了右上方
			int end = tr - 1;
			while(dr != end){
				System.out.print(matrix[dr--][dc++] + "\t");
			}
		}else{
			// 打印终止的条件为：右上方的点沿直线运动到了左下方
			int end = dr + 1;
			while(tr != end){
				System.out.print(matrix[tr++][tc--] + "\t");
			}
		}

		System.out.println();
	}
}