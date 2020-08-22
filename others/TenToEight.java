/**
	十进制转八进制
*/
public class TenToEight {
	public static void main(String[] args) {
		int num = 40;
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
			int tmp = num % 8;
			num /= 8;
			sb.insert(0, tmp);
		}
		System.out.println(sb.toString());
	}
}