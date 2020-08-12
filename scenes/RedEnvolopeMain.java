import java.util.ArrayList;

/**
	（字节跳动）场景题：让你设计一个微信发红包的api，你会怎么设计，不能有人领到的红包里面没钱，红包数值精确到分。
	**思路**：
	假设一共有 N 元，一共有 K 个人，则每个人拿到的钱可为 random(N - (K - 1) * 0.01)，然后更新N，直到最后一个人就直接 N。

	关键点：
		1、 确保红包的总和为 N
		2、 确保足够均匀
*/
public class RedEnvolopeMain {
	private static class RedEnvolope {
		double remainMoney;
		int peopleNum;

		private static final double MIN_MONEY = 0.01;


		public RedEnvolope(double remainMoney, int peopleNum) {
			this.remainMoney = remainMoney;
			this.peopleNum = peopleNum;
		}

		public boolean hasNext() {
			return peopleNum > 0;
		}

		public double next() {
			if(peopleNum == 1) {
				double lastPart = remainMoney;

				remainMoney = 0;
				peopleNum = 0;

				return (double)Math.round(lastPart * 100) / 100;
			}

			// 据说 微信红包 是这样实现的（确保当前能抢到金额的最大值为剩余红包均值的2倍）
			double max = remainMoney / peopleNum * 2;
			/**
				这种写法是不正确的： doube part = Math.rand() * remainMoney;
				极端情况下，第 1 个人可能就分走了 （N - 0.01）元钱，这样就导致后面 （K - 1） 个人分 0.01 元钱。
				当 K >= 3 时，肯定有人分到的钱为 0 元。
				
				所以，每次分配时，上限最好与 剩余红包均值 有关
			*/
			double part = Math.random() * max;
			part = part < MIN_MONEY ? MIN_MONEY : part;
			// 确保每次分到的金额的最小单位为 分（人民币单位）
			part = Math.floor(part * 100) / 100;

			remainMoney -= part;
			peopleNum--;

			return part;
		}
	}

	public static void main(String[] args) {
		int personNum = 7;
		double total = (personNum + 1) * 0.01;
		// double total = (personNum + 1) * 0.01;

		RedEnvolope re = new RedEnvolope(total, personNum);
		ArrayList<Double> list = new ArrayList<>();

		/**
			hasNext - next 借鉴了迭代器的思想
		*/
		while(re.hasNext()) {
			list.add(re.next());
		}

		System.out.println(list);
		double sum = 0;
		for(Double d: list) {
			sum += d;
		}

		System.out.println(String.format("<%f = %f>", sum, total));
	}
}