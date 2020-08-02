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

        int lcm = (nums[0] * nums[1]) / gcd(nums[0], nums[1]);

        System.out.println(String.format("%d 和 %d 的最小公倍数为 %d", nums[0], nums[1], lcm));
    }
    
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