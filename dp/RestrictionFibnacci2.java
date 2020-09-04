/**
	上楼梯，一次可以走 1~m 阶，共 n 阶，每次走的步数不能和前面两次相同，问到最后一阶有几种走法（输出对 1e9+7 取余数）
*/
public class RestrictionFibnacci2 {
	private static final int MOD = (int)1e9 + 7;
	private static int count = 0;

	private static int n, m;
	public static void main(String[] args) {
		int n = 7, m = 3;

		RestrictionFibnacci2.n = n;
		RestrictionFibnacci2.m = m;

		dfs(0, 0, 0);

		System.out.print(String.format("小明上 %d 阶楼梯总共有 %d 种方法", n, count));
	}

	private static void dfs(int pre1, int pre2, int cur) {
		if(cur == n) {
			count++;
			count = count % MOD;

			return;
		}

		for(int i = 1; i <= m; i++) {
			if(cur + i > n) {
				break;
			}
			if(i != pre1 && i != pre2) {
				dfs(i, pre1, cur + i);
			}
		}
	}
}