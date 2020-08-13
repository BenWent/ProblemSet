/**
	给4个数，求是否满足 24 点。输入{7,2,1,10}，输出true，因为 7*2+1*10=24
*/
public class Points24 {
	int[] nums = null;
	boolean flag = false;
	public static void main(String[] args) {
		
	}

	public boolean Game24Points (int[] arr) {
	    if(arr.length == 1 && arr[0] == 24){
	        return true;
	    }

	    for (int i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr.length; j++) {
	            if(i == j){
	                continue;
	            }
	            int[] temp = new int[arr.length-1];
	            int k = 0, l = 0;
	            for (; l < arr.length; l++) {
	                if(l != i && l != j){
	                    temp[k] = arr[l];
	                    k++;
	                }
	            } 
	            temp[k] = arr[i] + arr[j];
	            if(Game24Points(temp)) return true;
	            temp[k] = arr[i] - arr[j];
	            if(Game24Points(temp)) return true;
	            temp[k] = arr[i] * arr[j];
	            if(Game24Points(temp)) return true;
	            if(arr[j] != 0)
	                temp[k] = arr[i] / arr[j];
	            if(Game24Points(temp)) return true;
	        }
	    }
	    return false;
	}

	public boolean MyGame24Points (int[] arr) {
        char[] signs = {
            '+', '*', '/',
            '-', '*'
        };
        nums = arr;
        recur(signs, 0);

        return flag;
    }

    private void recur(char[] signs, int j) {
        if(j == signs.length - 1) {
            int sum = nums[0];
            for(int i = 1, index = 0; i < 4; i++) {
                switch(signs[index++]) {
                    case '+':
                        sum += nums[i];
                        break;
                    case '-':
                        sum -= nums[i];
                        break;
                    case '*':
                        sum *= nums[i];
                        break;
                    case '/':
                        sum /= nums[i];
                        break;
                }
            }

            if(sum == 24) {
                flag = true;
            }
            return;
        }
        for(int i = j; i < signs.length; i++) {
            swap(signs, i, j);
            recur(signs, j + 1);
            if(flag) {
                return;
            }
            swap(signs, i, j);
        }
	}

	private void swap(char[] signs, int i, int j) {
        char tmp = signs[i];
        signs[i] = signs[j];
        signs[j] = tmp;
    }
}