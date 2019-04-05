public class BestSightseeingPair_1014 {
    public static void main(String[] args) {
        Solution_1014 solution = new Solution_1014();
        int[] a = new int[]{1,2,2};
        System.out.println(solution.maxScoreSightseeingPair(a));
    }
}

class Solution_1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, cur = 0;
        for (int a: A) {
            res = Math.max(res, cur + a);
            cur = Math.max(cur, a) - 1;
        }
        return res;
    }
}
