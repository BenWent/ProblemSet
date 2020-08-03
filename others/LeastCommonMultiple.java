import java.util.Scanner;
import java.util.stream.Stream;

/**
	a b 的最小公倍数： (a * b) / gcd(a, b)
*/
public class LeastCommonMultiple{
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] nums = Stream.of(scan.nextLine().split("\\s+"))
            .mapToInt(e -> Integer.valueOf(e)).toArray();

        int lcm = (nums[0] * nums[1]) / gcdBySubNonRecur(nums[0], nums[1]);

        System.out.println(String.format("%d 和 %d 的最小公倍数为 %d", nums[0], nums[1], lcm));
    }

    /**
		更相减损术 非递归实现
    */
    private static int gcdBySubNonRecur(int a, int b) {
    	int bit = 0;
    	while(a != b) {
    		while(isEven(a) && isEven(b)) {
    			a >>= 1;
    			b >>= 1;

    			bit++;
    		}
    		while(isEven(a)) {
    			a >>= 1;
    		}
    		while(isEven(b)) {
    			b >>= 1;
    		}

    		// 确保 b > a
    		if(a == b) {
    			break;
    		} else if(a > b) {
    			int tmp = a;
    			a = b;
    			b = tmp;
    		}

    		// 求 （a, b）中较小的值 a 与 (b - a) 的最大公约数
    		b -= a;
    	}

    	return a * (1 << bit);
    }

    /**
		《九章算术》：更相减损术

		“可半者半之，不可半者，副置分母、子之数，以少减多，更相减损，求其等也。以等数约之。”
    */
	private static int gcdBySub(int a, int b) {
		if(a == b) {
			return a;
		}

		if(a > b) {
			// 确保 b > a
			return gcdBySub(b, a);
		} else if(isEven(a) && isEven(b)) {
			return gcdBySub(a >> 1, b >> 1) << 1;
		} else if(isEven(a)) {
			// 在 (a, b) 相差很大时，求 （a / 2, b）的最大公约数将大大提高优化空间
			// 比如：求(100, 1)的最大公约数时，正常情况下需要递归调用 100 次，但求（25, 1） 最大公约数时，只需递归调用 25 次
			return gcdBySub(a >> 1, b);
		} else if(isEven(b)){
			return gcdBySub(a, b >> 1);
		} else {
			return gcdBySub(a, b - a);
		}
	}
	
	/**
		@return i 为偶数返回 true，否则返回 false
	*/
	private static boolean isEven(int i) {
		return (i & 1) == 0;
	}

    /**
		最小公约数非递归实现
    */
	private static int gcdNonRecur(int a, int b) {
		while(b != 0) {
			int oldA = a;
			a = b;
			b = oldA % b;
		}

		return a;
	}
    
    /**
		最小公约数递归实现
    */
    private static int gcd(int a, int b){
        if(a > b){
        	return help(a, b);
        }

        return help(b, a);
    }

    private static int help(int a, int b){
    	int c = a % b;
    	if(c == 0){
    		return b;
    	}

    	return help(b, c);
    }
}