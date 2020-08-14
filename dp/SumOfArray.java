import java.util.stream.IntStream;

/**
	给你一个数组arr，和一个整数aim。如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false

	与打印字符串的所有子序列问题类似

	如果数组元素也能为负数呢？
*/
public class SumOfArray{

	/**
		index 表示数组 arr 的第 (index + 1) 个元素
	*/
	private static boolean accumulate(int[] arr, int index, int sum, int aim){
		if(index == arr.length){
			return sum == aim;
		}

		// 是否取 arr 的第 (index + 1) 个元素
		return accumulate(arr, index + 1, sum + arr[index], aim) || accumulate(arr, index + 1, sum, aim);
	}

	private static boolean accumulateDyna(int[] arr, int aim){
		int rows = arr.length;
        int cols = IntStream.of(arr).sum();

        if (cols < aim) {
            return true;
        }

        // r 表示 arr 的第 (r + 1) 个元素
        // c 表示所取 arr 的全部元素之和
        boolean[][] dp = new boolean[rows][cols + 1];
        for (int c = 0, r = rows - 1; c < cols; c++) {
            dp[r][c] = c == aim;
        }

        for (int r = rows - 2; r >= 0; r--) {
            for (int c = cols - arr[r]; c >= 0; c--) {
                dp[r][c] = dp[r + 1][c] || dp[r + 1][c + arr[r]];
            }
        }

        return dp[0][0];
	}
}