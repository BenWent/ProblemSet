import java.util.HashMap;

/**
	拼多多笔试题第二题：可以任意移动组成某个岛屿的某个 1，求移动后所得最大岛屿的 1 的个数
*/
public class IsolatedIslandsConnected {
	public static void main(String[] args) {
		int[][] arr = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}};

        HashMap<Integer, Integer> map = new HashMap<>();
        char tag = 'a';
        int oneTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    int oneNum = dfs(arr, i, j, 0, tag);
                    oneTotal += oneNum;

                    map.put((int)tag, oneNum);
                    tag = (char)(tag + 1);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 0) {
                    if(i > 0 && j > 0 &&
                        (arr[i][j - 1] != 0 && arr[i - 1][j] != 0 && arr[i][j - 1] != arr[i - 1][j])) { // 左上

                        max = Math.max(max, map.get(arr[i][j - 1]) + map.get(arr[i - 1][j]) + 1);
                    }
                    if(i > 0 && j < arr[i].length - 1 &&
                        (arr[i - 1][j] != 0 && arr[i][j + 1] != 0 && arr[i - 1][j] != arr[i][j + 1])) { // 右上

                        max = Math.max(max, map.get(arr[i][j + 1]) + map.get(arr[i - 1][j]) + 1);
                    }
                    if(i < arr.length - 1 && j < arr[i].length - 1 &&
                        (arr[i + 1][j] != 0 && arr[i][j + 1] != 0 && arr[i + 1][j] != arr[i][j + 1])) { // 右下

                        max = Math.max(max, map.get(arr[i][j + 1]) + map.get(arr[i + 1][j]) + 1);
                    }
                    if(i < arr.length - 1 && j > 0 &&
                        (arr[i + 1][j] != 0 && arr[i][j - 1] != 0 && arr[i + 1][j] != arr[i][j - 1])) { // 左下

                        max = Math.max(max, map.get(arr[i][j - 1]) + map.get(arr[i + 1][j]) + 1);
                    }
                    if(i < arr.length - 1 && i > 0 &&
                        (arr[i - 1][j] != 0 && arr[i + 1][j] != 0 && arr[i - 1][j] != arr[i + 1][j])) { // 上下

                        max = Math.max(max, map.get(arr[i - 1][j]) + map.get(arr[i + 1][j]) + 1);
                    }
                    if(j < arr[i].length - 1 && j > 0 &&
                        (arr[i][j - 1] != 0 && arr[i][j + 1] != 0 && arr[i][j - 1] != arr[i][j + 1])) { // 左右

                        max = Math.max(max, map.get(arr[i][j - 1]) + map.get(arr[i][j + 1]) + 1);
                    }
                }
            }
        }
        
        if(max > oneTotal) {
            max--;
        }

        System.out.println(max);
	}

	private static int dfs(int[][] arr, int i, int j, int count, int tag) {
        if (i < 0 || i == arr.length || j < 0 || j == arr[i].length || arr[i][j] != 1) {
            return count;
        }

        arr[i][j] = tag;
        count++;

        int top = dfs(arr, i - 1, j, count, tag);
        int down = dfs(arr, i + 1, j, count, tag);
        int left = dfs(arr, i, j - 1, count, tag);
        int right = dfs(arr, i, j + 1, count, tag);

        return Math.max(Math.max(top, down), Math.max(left, right));
    }
}