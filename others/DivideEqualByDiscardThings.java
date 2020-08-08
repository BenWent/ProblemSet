/**
	网易互联网 笔试题三

	现在有n个物品，每一个物品都有一个价值，现在想将这些物品分给两个人，要求这两个人每一个人分到的物品的价值总和相同（个数可以不同，总价值相同即可），
	剩下的物品就需要扔掉，现在想知道最少需要扔多少价值的物品才能满足要求分给两个人。
*/
public class DivideEqualByDiscardThings {
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[] values = {30, 60, 5, 15, 30};

		dispacthAndDiscard(values, 0, 0, 0, 0);

		System.out.println("最少丢弃价值: " + res);
	}

	private static void dispacthAndDiscard(int[] values, int index, int valueOne, int valueTwo, int valueDiscard) {
		if(index == values.length) {
			if(valueOne == valueTwo) {
				res = Math.min(res, valueDiscard);
			}
			
			return;
		}

		dispacthAndDiscard(values, index + 1, valueOne + values[index], valueTwo, valueDiscard);
		dispacthAndDiscard(values, index + 1, valueOne, valueTwo + values[index], valueDiscard);
		dispacthAndDiscard(values, index + 1, valueOne, valueTwo, valueDiscard + values[index]);
	}
}