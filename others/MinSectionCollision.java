import java.util.PriorityQueue;
import java.util.Arrays;

/**
	猿辅导 笔试题一

	小猿非常热爱学习，所以他在猿辅导上购买了N节课来提升自己，每节课有一个开始时间S和结束时间E（S和E均用正整数表示）。
	买完课程后，粗心的小猿发现这些课程之间有些时间冲突，幸好小猿有一种“一心多用”的超能力，能同时兼顾K节课上课。当然是K越大，
	使用这种能力就越累。请问小猿最少需要一心几用，才能上完所有他买的课程呢？

	代码来源：https://paste.ubuntu.com/p/xW2CsqMJ8B/
*/
public class MinSectionCollision {
	private static class Node implements Comparable<Node>{
		int start, end;
		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Node n2) {
			return this.start == n2.start ? this.end - n2.end : this.start - n2.start;
		}
	}
	public static void main(String[] args) {
		int[] starts = {2, 3, 7, 5, 2, 8, 1, 6, 8, 10, 11, 12, 13};
		int[] ends 	 = {6, 7, 9, 6, 3, 9, 2, 7, 9, 11, 12, 13, 14};
		int max = 1;

		Node[] nodes = new Node[starts.length];
		for(int i = 0; i < starts.length; i++) {
			nodes[i] = new Node(starts[i], ends[i]);
		}
		Arrays.sort(nodes);

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int i = 0; i < starts.length; i++) {
			if(heap.isEmpty() || heap.peek() > nodes[i].start) {
				heap.offer(nodes[i].end);
			} else {
				heap.poll();
				heap.offer(nodes[i].end);
			}
		}

		System.out.println(String.format("需要 1 心最少 %d 用", heap.size()));
	}
}