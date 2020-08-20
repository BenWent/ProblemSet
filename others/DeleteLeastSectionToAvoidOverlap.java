import java.util.PriorityQueue;
import java.util.Arrays;

/**
	商汤笔试题 3（leetcode 435） ：给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。注意：可以认为区间的终点总是大于它的起点。 
	区间[1，2]和[2，3]的边界相互“接触”，但没有相互重叠。

	我竟然也做出来了！
*/
public class DeleteLeastSectionToAvoidOverlap {
	private static class Section implements Comparable<Section>{
        int start, end;
        public Section(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Section s) {
            return this.start == s.start ? this.end - s.end : this.start - s.start;
        }
    }

    /**
     *
     * @param intervals int整型二维数组
     * @return int整型
     */
    public static int eraseOverlapIntervals (int[][] intervals) {
        int len = intervals.length;
        Section[] sections = new Section[len];
        for(int i = 0, index = 0; i < len; i++) {
            sections[index++] = new Section(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(sections);
        PriorityQueue<Section> queue = new PriorityQueue<>();

        for(Section s: sections) {
            if(!queue.isEmpty() && queue.peek().end > s.start) {
                continue;
            }
            queue.offer(s);
        }
        return len - queue.size();
    }

	public static void main(String[] args) {
		int[][] intervals = {
			{1, 2},
			{2, 3},
			{3, 4},
			{1, 3}
		};

		System.out.println(eraseOverlapIntervals(intervals));
	}
}