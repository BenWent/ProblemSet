import java.util.Arrays;

/**
	输入数字 N ，按顺序打印出从 1 到最大的 N 位十进制数。
	比如输入 3 ，则打印 1、2、3、...、999
	---《剑指Offer》 面试题 17 ，P114
*/
public class BigNumber{
	public static void main(String[] args){
		int n = Integer.valueOf(args[0]);
		// 用字符数组表示 大数
		char[] bigNumber = new char[n];
		Arrays.fill(bigNumber, '0');

		// while(increment(bigNumber)){
		// 	printNumber(bigNumber);
		// }
		solutionRecursive(bigNumber, 0);
	}

	/**
		n 位十进制数其实就是 n 个从 0 到 9 的全排列
	*/
	private static void solutionRecursive(char[] num, int index){
		if(index == num.length){
			printNumber(num);

			return;
		}

		for(int i = 0; i < 10; i++){
			num[index] = (char)(i + '0');
			solutionRecursive(num, index + 1);
		}
	}

	/**
		将字符数组表示的数加 1 
		@return 加 1 后，值小于或等于最大 N 位十进制数，返回 true，否则返回 false
	*/
	private static boolean increment(char[] number){
		boolean notOverFlow = true;

		int index = number.length - 1;
		int carry = 1;
		while(carry != 0) {
			int current = number[index] - '0' + carry;
			if(current == 10) {
				if(index == 0 && number[index] == '9') {
					// 最高位发生了进位，说明当前数加 1 操作后超过了 n 位数的表示范围
					notOverFlow = false;

					break;
				}

				number[index] = '0';
				index--;
			} else {
				number[index] = (char)(current + '0');
				carry = 0;
			}
		}

		return notOverFlow;
	}

	/**
		打印当前字符表示的数的有效位
	*/
	private static void printNumber(char[] number){
		boolean isFirstZero = true;
		for(int i = 0; i < number.length; i++){
			if(isFirstZero && number[i] != '0')
				isFirstZero = false;
			if(!isFirstZero)
				System.out.print(number[i]);
		}
		System.out.println();
	}
}