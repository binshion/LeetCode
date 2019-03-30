import javax.xml.crypto.Data;
import java.util.Date;

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        Solution_121 solution = new Solution_121();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

/**
 * 虽然是一道easy难度题目，但是模拟起来有点费劲，暴力破解和这个思路差异有点大。
 * 时间复杂度O(n²)下降到O(n)。
 * 7,1,5,3,6,4
 * 7后面最大值是6
 * 1后面最大值是6
 * 5后面最大值是6
 * 3后面最大值是6
 * 6后面最大值是4
 * 最大值求法，反向求解，即 6 - 3 - 5 - 1 - 7
 * 由于越往前，值只可能越大，所以比较差值只需要比较一次即可
 */
class Solution_121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        } else {
            int[] max = new int[prices.length - 1];
            int maxIndex = max.length - 1;  //第一个位置
            for (int i = prices.length - 1; i > 0; i--) {
                if (i == prices.length - 1) {
                    max[maxIndex--] = prices[i];
                } else {
                    max[maxIndex--] = Math.max(max[maxIndex + 1], prices[i]);
                }
            }

            int tempMax = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                tempMax = Math.max(tempMax, max[i] - prices[i]);
            }
            return tempMax;
        }
    }

    /**
     * 暴力破解法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        long starts = System.currentTimeMillis();
        System.out.println(starts);
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (i > 0) {
                if (prices[i] >= prices[i - 1]) {
                    continue;
                }
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    continue;
                }
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        long ends = System.currentTimeMillis();;
        System.out.println(ends);
        System.out.println(ends -starts);
        return max;
    }
}
