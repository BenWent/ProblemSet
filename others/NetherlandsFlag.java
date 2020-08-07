import java.util.Random;

public class NetherlandsFlag{
	public static final Random random = new Random();
	public static void main(String[] args){
		int[] array = Util.generateRandomIntArray(random.nextInt(30) + 1);
		System.out.print("整理前的数组:");
		Util.printIntArray(array);

		int num = array[random.nextInt(array.length)];
		System.out.println("num = " + num);

		System.out.print("整理后的数组:");
		netherlandFlagProblem(array, num);
		Util.printIntArray(array);
	}

	/**
		荷兰国旗问题：给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于
		num的数放在数组的中间，大于num的数放在数组的右边
		时间复杂度：O(n)，空间复杂度：O(1)
	*/
	public static void netherlandFlagProblem(int[] array, int num){
		if(array == null || array.length <= 1){
			return;
		}

		// 在数组中，以[0, smallerPartitionRight]为边界的元素<=num，以[largerPartitionLeft, N]为边界的元素都>num
		// 以(smallerPartitionRight, largerPartitionLeft)为边界的元素都等于num
		// 引入两个变量就将数组暗地里划分成了3个区
		int smallerPartitionRight = -1, largerPartitionLeft = array.length;
		int current = 0;
		while(current < largerPartitionLeft){
			if(array[current] < num){
				// 等于num的数组整体右移一位，并将当前元素放入到小于num的数组的末尾
				Util.swapInt(array, ++smallerPartitionRight, current);
				
				++current;
			}else if(array[current] > num){
				Util.swapInt(array, --largerPartitionLeft, current);

				// 因为将一个不确定的数(是大于、小于还是等于num不清楚)换到了当前位置，
				// 所以需要对但当前位置的数重新进行验证，即current不能自增
			}else{
				// 遇到等于num的元素直接越过

				++current;
			}
		}

	}

	/**
		给定一个数组arr，和一个数num，请把小于等于num的数放在
		数组的左边，大于num的数放在数组的右边	
		时间复杂度：O(n)，空间复杂度：O(1)
	*/
	public static void arangement(int[] array, int num){
		if(array == null || array.length <= 1){
			return;
		}

		// 在数组中，以[0, smallerPartitionRight]为边界的元素<=num，以(smallerPartitionRight, N)为边界的元素都>num
		// 即该变量的引入，暗地里就将数组划分成了两个区。左区的元素小于等于num，右区的元素大于num
		int smallerPartitionRight = -1;
		for(int i = 0; i < array.length; i++){
			if(array[i] <= num){
				// 左区扩张(为新增的小于等于num的数占位)，并将 小于等于num的数 引入左区

				int tmp = array[++smallerPartitionRight];
				array[smallerPartitionRight] = array[i];
				array[i] = tmp;
			}
		}

	}
}