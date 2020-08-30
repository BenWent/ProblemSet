import java.util.Arrays;

/**
	将字符串数组进行拼接，保证最终得到的字符串符合最小字典序
	证明该题使用的贪心策略正确
	1.证明 传递性
	2.证明 交换最终结果的字符串的任意两个字符串，会导致结果变得更大。	
*/
public class NumArrayToMaxString{
	private static class MyComparator implements Comparator<String, String>{
		@Override
		public int compare(String a, String b){
			return (a + b).compare(b + a);
		}
	}

	public static String lowerString(String[] strs){
		if(strs == null || strs.length == 0)
			return "";

		Arrays.sort(strs, new MyComparator());
		String res = "";
		for(int i = 0; i < strs.length; i++){
			res += strs[i];
		}
		return strs;
	}
}