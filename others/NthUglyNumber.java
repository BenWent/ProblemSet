import java.util.*;

/**
	求第 n 个丑数
*/
public class NthUglyNumber{
	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);
		System.out.println(String.format("第 %d 个丑数是： %d", n, nthUglyNumber(n)));
	}

	private static int nthUglyNumber(int n){
		if(n < 7) {
			return n;
		}
		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;

		for(int i = 1, p2 = 0, p3 = 0, p5 = 0; i < n; i++) {
			int i2 = uglyNumbers[p2] * 2;
			int i3 = uglyNumbers[p3] * 3;
			int i5 = uglyNumbers[p5] * 5;

			int uglyNumber = Math.min(Math.min(i2, i3), i5);
			System.out.print(uglyNumber + " ");
			uglyNumbers[i] = uglyNumber;

			if(uglyNumber == i2) {
				p2++;
			}
			if(uglyNumber == i3) {
				p3++;
			}
			if(uglyNumber == i5) {
				p5++;
			}
		}
		System.out.println();

		return uglyNumbers[n - 1];
	}
}