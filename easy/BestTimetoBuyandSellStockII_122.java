public class BestTimetoBuyandSellStockII_122 {
    public static void main(String[] args){
        Solution_122 solution = new Solution_122();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
    }
}

/**
 * 股票最佳投资方案模拟
 * 思路：只需要模拟股票趋势图，机不难看出，只要是递增趋势就跟进，一旦下跌，
 *  则卖出。即只要是递增涨势，在买入范围内，一旦下跌就卖出。
 *  prices[i] - prices[i - 1]
 */
class Solution_122 {
    public int maxProfit(int[] prices) {
        int index = 1;
        int profit = 0;
        while (index < prices.length) {
            if (prices[index] > prices[index - 1]) {
                profit += prices[index] - prices[index - 1];
            }
            index++;
        }
        return profit;
    }
}
