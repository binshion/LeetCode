public class UniquePaths_62 {
    public static void main(String[] args){
        Solution_62 solution = new Solution_62();
        System.out.println(solution.uniquePaths(7, 3));
    }
}

/**
 * 找从左上到右下的所有路径，只能右或下移动
 */
class Solution_62 {
    /**
     * 保存计算值备用，避免计算多次
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] list = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    list[i][j] = 1;
                } else {
                    list[i][j] = list[i - 1][j] + list[i][j - 1];
                }
            }
        }
        return list[m - 1][n - 1];
    }

    /**
     * 重复计算导致超时
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
