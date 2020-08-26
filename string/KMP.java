/**
	有一个主串 S 和一个模式串 P，如果能从 S 中找到一个 P 则返回第一个匹配字符串在 S 中的下标值，否则返回 -1
	时间复杂度为 O(M + N)

	JDK String#indexOf 为什么不使用 KMP 算法：
		JDK的编写者们认为大多数情况下，字符串都不长，使用原始实现可能代价更低。因为 KMP 和 Boyer-Moore 算法
		都需要预先计算处理来获得辅助数组，需要一定的时间和空间，这可能在短字符串查找中相比较原始实现耗费更大的代价。
		而且一般大字符串查找时，程序员们也会使用其它特定的数据结构，查找起来更简单。这有点类似于排除特定情况下的快速排序了。
		不同环境选择不同算法。
*/
public class KMP {
	public static void main(String[] args) {
		String S = "ababbababa";
		String P = "ababa";

		System.out.println("主  串: " + S);
		System.out.println("模式串: " + P);
		System.out.println(match(S, P, buildNextArray(P)));
	}

	private static int match(String S, String P, int[] next) {
		char[] sArr = S.toCharArray();
		char[] pArr = P.toCharArray();
		int i = 0, j = 0;
		while(i < sArr.length && j < pArr.length) {
			if(j == -1 || sArr[i] == pArr[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		return j == pArr.length ? i - pArr.length : -1;
	}

	private static int[] buildNextArray(String p) {
		char[] pArr = p.toCharArray();
		int[] next = new int[pArr.length + 1];
		next[0] = -1;

		int i = 0, j = -1;
		while(i < pArr.length) {
			if(j == -1 || pArr[i] == pArr[j]) {
				++i;
				++j;

				next[i] = j;
			} else {
				j = next[j];
			}
		}
		

		return next;
	}
}