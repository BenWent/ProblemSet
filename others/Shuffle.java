import java.util.Random;
import java.util.Arrays;

/**
	Fisher-Yates Shuffle Algorithm
*/
public class Shuffle{
	private static final Random r = new Random();
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		for(int i = arr.length - 1; i >= 0; i--){
			int p = i;
			// 确保任何一个元素都不在其原位置处
			while(p == i && i != 0){
				p = r.nextInt(i + 1);
			}

			int tmp = arr[i];
			arr[i] = arr[p];
			arr[p] = tmp;
		}

		System.out.println(Arrays.toString(arr));
	}
}