import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Collections;

/**
	如何得到一个数据流中的中位数
*/
public class MindNumberInStream{
	// 该队列(构建一个大根堆)中存储比中值小的数
	private static PriorityQueue<Integer> lowerHeap = new PriorityQueue<>(new Comparator<Integer>(){
		@Override
		public int compare(Integer i1, Integer i2){
			return i2 - i1;
		}
	});
	// 该队列(维护一个小根堆)存储比中值大的数
	private static PriorityQueue<Integer> higherHeap = new PriorityQueue<>();

	private static LinkedList<Integer> stream = new LinkedList<>();

	public static void main(String[] args)throws Exception{
		while(true){
			int value = (int)(Math.random() * 1000 + 1);
			stream.add(value);
			System.out.println("输入数据:" + value + ", 当前的中值为:" + getMedian(value));
			Collections.sort(stream);
			System.out.println("当前流数据排序的结果为:" + stream);

			Thread.sleep(3000);
		}
	}

	private static int getMedian(int ele){
		// 先将数存入小值区域
		lowerHeap.offer(ele);
		// 取出小值区域的最大值
		int highestValueInLowerHeap = lowerHeap.poll();
		// 将小值区域的最大值放入大值区域
		higherHeap.offer(highestValueInLowerHeap);

		if(lowerHeap.size() < higherHeap.size()){
			int lowestValueInHigherHeap = higherHeap.poll();
			lowerHeap.offer(lowestValueInHigherHeap);
		}

		if(lowerHeap.size() > higherHeap.size()){
			return lowerHeap.peek();
		}

		return (lowerHeap.peek() + higherHeap.peek()) / 2;
	}
}