import java.util.LinkedList;

/**
	在一间房间总共有n个人（下标0～n-1），只能有最后一个人活命。

	按照如下规则去杀人：
	所有人围成一圈
	顺时针报数，每次报到q的人将被杀掉
	被杀掉的人将从房间内被移走
	然后从被杀掉的下一个人重新报数，继续报q，再清除，直到剩余一人

	时间复杂度：O(nq)
	空间复杂度：O(n)
*/
public class Josephus{
	public static void main(String[] args){
		int n = 41;
        int q = 3;

        // arr[i] == 0，代表 第 (i + 1)个人没有报过数；反之，则报过数
        int[] arr = new int[n];
        int count = 0;
        int loop = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (loop++ < q) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    count++;
                }

                if (count == q) {
                    arr[i] = 1;
                    count = 0;

                    loop = 0;

                    // System.out.print((i + 1) + " ");
                    list.add(i + 1);
                }
            }
        }
        System.out.println("the last one is " + list.getLast());
	}
}