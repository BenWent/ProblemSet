import java.util.Arrays;

/**
	一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。给你每一个项目开始的时间和结束的时间（给你一个数组，里面是一个个具体的项目），
	你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。

	按照最早结束时间进行贪心
*/
public class ArrangeMeeting{
    static class Program implements Comparable {
        private int start;
        private int end;

        @Override
        public int compareTo(Object o) {
            return end - ((Program) o).end;
        }
    }

    public static void main(String[] args) {

    }

    private static int solution(Program[] programs) {
        // 按照项目的结束时间对项目进行排序
        Arrays.sort(programs);
        int end = programs[0].end;
        int count = 1;
        for (int i = 1, len = programs.length; i < len; i++) {
            // 开始时间早于上一个项目的结束时间的项目，由于时间冲突不能使用会议室
            if (programs[i].start >= end) {
                count++;

                end = programs[i].end;
            }
        }

        return count;
    }
}