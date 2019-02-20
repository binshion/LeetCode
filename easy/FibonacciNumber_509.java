import com.sun.org.apache.regexp.internal.RE;

/**
 * 1.常规斐波那契序列表达式，递归调用
 * 2.动态递归，数组存放历史数据，减少重复计算
 * 3.临时变量循环使用，优化空间复杂度
 */
public class FibonacciNumber_509 {
    public static void main(String[] args){
        Solution_509 solution = new Solution_509();
        System.out.println(solution.fib3(4));
    }
}

class Solution_509 {
    /**
     * 常规斐波那契数列的写法
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    /**
     * 动态规划
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            int[] dynamic = new int[N + 1];
            dynamic[0] = fib2(0);
            dynamic[1] = fib2(1);
            for (int i = 2; i < dynamic.length; i++) {
                dynamic[i] = dynamic[i - 1] + dynamic[i - 2];
            }

            return dynamic[N];
        }
    }

    /**
     * 临时变量计算，空间复杂度优化
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            int temp1 = 0;
            int temp2 = 1;
            int temp = 0;
            for (int i = 2 ; i <= N; i++) {
                temp = temp1 + temp2;
                temp1 = temp2;
                temp2 = temp;
            }
            return temp;
        }
    }
}
