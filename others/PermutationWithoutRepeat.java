import java.util.HashSet;

/**
	1.打印一个字符串的全排列(允许出现重复字符串)

	2.打印一个字符串的全排列(不允许出现重复字符串)
*/
public class PermutationWithoutRepeat{
	public static void main(String[] args) {
        String str = "abc";
        permutation(str.toCharArray(), 0);
    }

    // 将 n 个不同的物体放入 n 个不同的箱子，每个箱子只能放入一个物体，共有多少种放入方法
    // 第 1 个物体有 n 种放法
    // 第 2 个物体有 n - 1 种放法
    // ...
    // 第 n 个物体有 1 种放法
    private static void permutation(char[] chars, int index) {
        if (index == chars.length) {
            // 第 n 个物体放入到第 n 个箱子中，开始打印
            System.out.println(String.valueOf(chars));
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if(!set.contains(chars[i])){
                set.add(chars[i]);

                swap(chars, i, index);
                permutation(chars, index + 1);
                swap(chars, i, index);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}