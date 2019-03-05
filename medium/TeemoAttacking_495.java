public class TeemoAttacking_495 {
    public static void main(String[] args) {
        Solution_495 solution = new Solution_495();
        System.out.println(solution.findPoisonedDuration(new int[]{1,4}, 2));
    }
}

/**
 * 提莫攻击时间点数组，中毒持续时间
 */
class Solution_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = timeSeries.length - 1; i >= 0; i--) {
            if (i == timeSeries.length - 1) {
                result += duration;
            }
            if (i > 0) {
                result += timeSeries[i] - timeSeries[i - 1] >= duration ? duration : timeSeries[i] - timeSeries[i - 1];
            }
        }
        return result;
    }
}
