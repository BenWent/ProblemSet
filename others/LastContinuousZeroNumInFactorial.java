/**
	爱奇艺笔试第一题 n! 的最后有几个零
	链接：https://www.nowcoder.com/questionTerminal/6ffdd7e4197c403e88c6a8aa3e7a332a
来源：牛客网

解释：比如100/5=20，即有20个数包含因数5：5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100。
	这20个数中又有20/5=4个包含因数5:25,50,75,100（可以把前面的20个数看成5*1，5*2，5*3，5*4，5*5，5*6，5*7，5*8，
	5*9，5*10,，5*11，5,12，5*13，5*14，5*15，5*16，5*17，5*18，5*19，5*20），然后这4个数中的因数5又被计算过了，
	即可。
*/
public class LastContinuousZeroNumInFactorial{
	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);
		int num = n;
		int count = 0;
		while(n != 0) {
			count += n / 5;

			n /= 5;
		}
		System.out.println(String.format("%d! 最后有 %d 个连续零", num, count));
	}
}