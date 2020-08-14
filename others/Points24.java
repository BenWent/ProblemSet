/**
	给4个数，求是否满足 24 点。输入{7, 2, 1, 10}，输出true，因为 7 * 2 + 1 * 10=24
*/
public class Points24 {
	int[] nums = null;
	boolean flag = false;
	public static void main(String[] args) {
		
	}

    /**
        解法 1

        考虑了数字的顺序：
            1. 没有考虑顺序，满足题意的答案只有一种 7 * 2 + 1 * 10 = 24
            2. 考虑数字顺序，满足题意的答案有多种 2 * 7 + 1 * 10 = 24 、1 * 10 + 7 * 2 = 24
    */
	public boolean Game24Points(int[] arr) {
	    if(arr.length == 1 && arr[0] == 24){
	        return true;
	    }

	    for (int i = 0; i < arr.length; i++) {
            /**
                没有写成：
                for(int j = i + 1; j < arr.length; j++){...}
                是因为考虑了数字可能换序，比如考虑了这种情况：(7 - 2) 与 (2 - 7) 
            */
	        for (int j = 0; j < arr.length; j++) {
	            if(i == j){ // 每个元素只能被使用一次
	                continue; 
	            }

	            int[] compressedArr = new int[arr.length-1];
	            int lastIndex = 0;
	            for (int k = 0; k < arr.length; k++) {
	                if(k != i && k != j){ // 每个元素只能被使用一次
	                    compressedArr[lastIndex++] = arr[k];
	                }
	            }

                // 加法
	            compressedArr[lastIndex] = arr[i] + arr[j];
	            if(Game24Points(compressedArr)) {
                    return true;
                }

                // 减法
	            compressedArr[lastIndex] = arr[i] - arr[j];
	            if(Game24Points(compressedArr)) {
                    return true;
                }

                // 乘法
	            compressedArr[lastIndex] = arr[i] * arr[j];
	            if(Game24Points(compressedArr)) {
                    return true;
                }

                // 除法
	            if(arr[j] != 0) {
	                compressedArr[lastIndex] = arr[i] / arr[j];
                    if(Game24Points(compressedArr)) {
                        return true;
                    }
                }
	        }
	    }
	    return false;
	}


    /**
        解法 2
    */
    public boolean Game24PointsRecur (int[] arr) {
        if(arr == null || arr.length == 0) {
             return false;
        }

        recur(arr, 1, arr[0]);

        return flag;
     }

    /**
        解法 2 依赖
    */
    public void recur(int[] arr, int index,int sum) {
        if(index >= arr.length || flag) { // flag 出现在这里是为了减枝
            if(sum == 24) {
                flag = true;
            }

            return;
        }

        recur(arr, index + 1, sum + arr[index]);
        recur(arr, index + 1, sum - arr[index]);
        recur(arr, index + 1, sum * arr[index]);
        if(arr[index] != 0) {
            recur(arr, index + 1, sum / arr[index]);
        }
    }
}