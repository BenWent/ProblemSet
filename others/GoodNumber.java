import java.util.HashMap;

/**
	商汤笔试题 1：给定一个字符串序列，包含字母，数字以及空格，请问该字符串最多能组成多少个“Good”。 字符串区分大小写，每个字符只能使用一次，
	且不能调换字符顺序。
*/
public class GoodNumber {
	public static void main(String[] args) {
		String line = "oGGooGooddod"; // 答案为 2

		int count = 0;
		HashMap<String, Integer> map = new HashMap<>();
		map.put("G", 0);
		map.put("Go", 0);
		map.put("Goo", 0);

		for(char ch: line.toCharArray()) {
			if(ch == 'G') {
				map.put("G", map.get("G") + 1);
			} else if(ch == 'o') {
				if(map.get("Go") > 0) {
					map.put("Goo", map.get("Goo") + 1);
					map.put("Go", map.get("Go") - 1);
				} else if(map.get("G") > 0){
					map.put("Go", map.get("Go") + 1);
					map.put("G", map.get("G") - 1);
				}
			} else if(ch == 'd') {
				if(map.get("Goo") > 1) {
					count++;

					map.put("Goo", map.get("Goo") - 1);
				}
			}
		}

		System.out.println(count);
	}
}