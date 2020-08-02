import java.util.ArrayList;

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
        // 题目给定数据
		int n = 7;
        int q = 3;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }

        q--;
        for(int count = 0; n > 1; n--) {
            count = (count + q) % n;
            list.remove(count);
        }

        System.out.println("the last one is " + list.get(0));
	}
}