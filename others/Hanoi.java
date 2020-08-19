/**
	汉诺塔问题

	时间复杂度：
		T(n) = T(n - 1) + 1 + T(n - 1) = 2T(n - 1) +
		O(2^n)
*/
public class Hanoi{
	public static void main(String[] args) {
    	solution(3, "左", "右", "中");
    }

    public static void solution(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println(String.format("move %d from %s to %s", 1, from, to));
        } else {
            solution(n - 1, from, help, to);
            System.out.println(String.format("move %d from %s to %s", n, from, to));
            solution(n - 1, help, to, from);
        }
    }
}