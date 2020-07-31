/**
    使用数学方法对问题进行分析后，得出该问题的递推公式
*/
public class JosephusOpt{
    public static void main(String[] args){
        // 205769
        int n = Integer.MAX_VALUE / 10000;
        int q = Integer.MAX_VALUE / 1000000;

        if (n == 1) {
            System.out.println(1);
        }

        // 最后一个报数的人的编号满足递推公式 f[n] = (f[n - 1] + q) % n; // 编号从 0 开始
//        int[] f = new int[n + 1];
//        f[1] = 0;
//        for(int i = 2; i < f.length; i++){
//            f[i] = (f[i - 1] + q) % i;
//        }
//        System.out.println(f[n] + 1);

        // 空间复杂度为 O(1) 的实现
        int res = 0, pre = 0;
        int index = 2;
        while (n-- > 1) {
            res = (pre + q) % index++;
            pre = res;
        }
        System.out.println(res + 1); // 205769
    }
}
