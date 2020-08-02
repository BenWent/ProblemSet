public class LowestCommonAncestor{
	public static void main(String[] args){
		int m = 25, n = 30;
		System.out.println(String.format("<%d, %d> 的最小公倍数为: %d", m, n, m * n / gcd(m, n)));
	}

	private static int gcd(int m, int n) {
		if(n == 0) return m;
		return gcd(n, m % n);
	}
}