public class MinCostClimbingStairs_746 {
    public static void main(String[] args) {
        Solution_746 solution = new Solution_746();
        System.out.println(solution.minCostClimbingStairs(new int[]{2,2,1,0}));
    }
}

class Solution_746 {
    public static int minCostClimbingStairs(int[] cost) {
        int minCostToReachLastStep = 0;
        int minCostToReachSecondLastStep = 0;
        for (int i = 0; i <= cost.length; i++) {
            int minCostToReachCurrentStep = Math.min(minCostToReachLastStep + getStepCost(i-1, cost), minCostToReachSecondLastStep + getStepCost(i-2, cost));
            minCostToReachSecondLastStep = minCostToReachLastStep;
            minCostToReachLastStep = minCostToReachCurrentStep;
        }

        return minCostToReachLastStep;
    }

    private static int getStepCost(int i, int[] cost) {
        if (i < 0) {
            return 0;
        }
        else return cost[i];
    }
 }
