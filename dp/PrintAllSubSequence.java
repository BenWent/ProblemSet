/**
	打印一个字符串的全部子序列，包括空字符串
*/
public class PrintAllSubSequence{
	public static void main(String[] args) {
        String s = "abc";

        printAllSubString(s.toCharArray(), 0, "");
    }

    private static void printAllSubString(char[] chars, int index, String res) {
        if(index == chars.length){
            System.out.println(res);
            return;
        }

        // 需要第 index 个字符
        printAllSubString(chars, index + 1, res + chars[index]);
        // 剔除第 index 个字符
        printAllSubString(chars, index + 1, res);
    }
}