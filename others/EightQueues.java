/**
	在 8 * 8 的国际象棋上放置 8 个皇后棋子
*/
public class EightQueues{
	 private static int map = 0;
    private static final int TABLE_SIZE = 4;
    private static int[][] table = new int[TABLE_SIZE][TABLE_SIZE];

    public static void main(String[] args) {
        solution(0);
        System.out.println(String.format("there are %d ways for placing %d queues in %d * %d table"
                , map, TABLE_SIZE, TABLE_SIZE, TABLE_SIZE));
    }

    private static void solution(int r) {
        if (r >= TABLE_SIZE) {
            map++;
            printTable();

            return;
        }

        for (int c = 0; c < TABLE_SIZE; c++) {
            if (checkValidity(r, c)) {
                table[r][c] = 1;
                solution(r + 1);
                table[r][c] = 0;
            }
        }
    }

    /**
     * 将皇后放在 [r][c] 处是否符合规则
     */
    private static boolean checkValidity(int r, int c) {
        for (int row = r - 1; row >= 0; row--) { // 列
            if (table[row][c] == 1)
                return false;
        }

        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) { // 右对角线
            if (table[i][j] == 1)
                return false;
        }

        for (int i = r - 1, j = c + 1; i >= 0 && j < TABLE_SIZE; i--, j++) { // 右对角线
            if (table[i][j] == 1)
                return false;
        }

        return true;
    }

    /**
     * 打印正确放置皇后位置的棋盘
     */
    private static void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                if (table[i][j] == 1) {
                    System.out.print("O ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println("\n--------------------------------\n");
    }

}