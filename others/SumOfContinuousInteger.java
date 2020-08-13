/**
	BiliBili 2020 笔试题2

	给定一个正整数N，试求有多少组连续正整数满足所有数字之和为N? (1 <= N <= 10 ^ 9)
	input 	: 5
	output 	: 2
	输出解释：共有两组连续整数([5],[2,3])求和后为 5。
*/
public class SumOfContinuousInteger {
	// 双指针（滑动窗口）
	public static void main(String[] args) {
		int n = 9;
        int count = 1;
        int one = 1, two = 2;
        int sum = one + two;
        int half = n >> 1;
        while(one != two && one <= half) {
            if(sum <= n) {
                if(sum == n) {
                    count++;
                }
                
                two++;
                sum += two; 
            } else {
                sum -= one;
                one++;
            }
        }
        
        System.out.println(count);
	}
}