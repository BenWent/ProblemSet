/**
	求平法根：
		1、二分法
		2、牛顿迭代法
*/
public class Sqrt {
	public static void main(String[] args) {
		int m = 3;
		System.out.println(String.format("%d 开根号的结果为: %f", m, newtonIterator(m)));
	}

	/**
		使用二分法求给定值的开根号的结果的近似值
	*/
	private static int dichotomy(int m) {
		int low = 1, high = m;
		while(low < high) {
			int mid = (low + high) >> 1;
			int square = mid * mid;
			if(square == m) {
				return mid;
			} else if(square > m) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return high;
	}

	/**
		使用牛顿迭代法
		y = x² - C
		在给给定横坐标 x0 的切线方程为： f(x) = 2x0(x - x0) + x0² - C = 2x0x - (x0² + C)
		令 f(x) = 0，有 x = 1/2 * (x0 + C/x0) —— x 为 过点(x0, x0² - C) 的切线与横坐标的交点
	*/
	private static double newtonIterator(int m) {
		if(m == 0) {
			return 0;
		}
		double C = m, x0 = C;
		while(true) {
			double x1 = 0.5 * (x0 + C/x0);
			if((x0 - x1) < 1e-20){
				break;
			}
			x0 = x1;
		}
		return x0;
	}
}