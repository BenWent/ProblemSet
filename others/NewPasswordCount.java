import java.util.HashMap;
import java.util.Scanner;

/**
	搜狗笔试 3 
	汪仔制定了一种密码生成的方法。他用一个初始数字串和一系列规则生成若干新的数字密码（新密码数字串和初始数字串不能相同）。
	假设汪仔的初始数字串是123，他开始准备生成新的数字密码，首先在新的密码第1位先写下他喜欢的任意一个数字（从0到9），那将是新密码的第1位数字。
	例如汪仔的最爱数字是9，新密码的第2个数字是初始数字串的第2个数字与新密码中已经写下的第1个数字的算术平均值，在这种情况下，算术平均值等于
	（2+9）/2=5.5，汪仔可以根据自己的意愿向上或向下取整，例如他选择数字5并将结果数字放在新密码的第2个位置。后续汪仔以相同的方式将初始数字串的
	第3个数字和新密码的第2个数字计算平均值，结果是（5+3）/2=4，由于这种情况整除，所以答案唯一，新密码的第3个位置是4。按照这样的规则新密码的第i个
	数字等于初始数字串的第i个数字和他的新密码的第i-1个数字的算术平均值（向上或向下取整），汪仔可以获得 123 -> 954 ，这只是其中一种的新密码情况。
	事实上，从 123 3个数字和新密码的第2个个数字计算平均值，结果是（5+3）/2=4，由这种情况整除，所以答案唯，新密码的第3个位置是4。
	按照这样的规则新密码的第i个数字等于初始数字串的第个数字和他的新密码的第-1个数字的算术平均值（向上或向下取整），汪仔可以获得123->954。
	这只是其中的一种新密码情况。事实上，从123出发，总共可以得到如下的21个密码（123自己不算）：
	012
	112 122 （123 重复删除）
	222 223
	322 323 333
	433 
	533 543 544
	643 644
	743 744 754
	854
	954 964 965
*/
public class NewPasswordCount {
	private static HashMap<String, Long> prefixMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        char[] arr = input.toCharArray();
        long total = 0;
        for (int i = 0; i <= 9; i++) {
            total += dfs(arr, i, 1);
        }
        if(duplicate(arr)) {
            total--;
        }

        System.out.println(total);
    }

    private static long dfs(char[] arr, int pre, int index) {
        if (index == arr.length) {
            return 1;
        }

        String prefix = pre + "_" + index;
        if (prefixMap.containsKey(prefix)) {
            return prefixMap.get(prefix);
        }

        long count = 0;
        int sum = arr[index] - '0' + pre;
        int mean = sum >> 1;
        count += dfs(arr, mean, index + 1);
        if ((sum & 1) == 1) {
            // 第二种选择
            count += dfs(arr, mean + 1, index + 1);
        }
        prefixMap.put(prefix, count);

        return count;
    }

    private static boolean duplicate(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int sum = (arr[i - 1] - '0') + (arr[i] - '0');
            int num = arr[i] - '0';
            int mean = sum >> 1;
            if ((sum & 1) == 0) {
                if (mean != num) {
                    return false;
                }
            } else {
                if (num != mean && num != mean + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}