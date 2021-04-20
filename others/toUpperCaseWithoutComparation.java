import java.util.Arrays;

/**
	将字符串里的小写字母转换成大写的。 要求不通过比较
	--------腾讯校招

	a~z的ascii码：97~122 也就是：1 1 00001~1 1 11010
	A~Z的ascii码：65~90 也就是： 1 0 00001~1 0 11010
	通过判断第  位是否是0,1而得到是小写字母还是大写字母
*/
public class toUpperCaseWithoutComparation {
	public static void main(String[] args) {
		String src = "abCdEFgHijkLmNoPQrStuvWXyz";
		int FIFTH_BIT = 1 << 5;
		char[] srcCharArray = src.toCharArray();
		for(int i = 0; i < srcCharArray.length; i++) {
			if((srcCharArray[i] & FIFTH_BIT) > 0) {
				srcCharArray[i] -= 32;
			}
		}

		System.out.println(String.valueOf(srcCharArray));
	}
}