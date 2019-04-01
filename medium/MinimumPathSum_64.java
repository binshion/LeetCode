public class MinimumPathSum_64 {
    public static void main(String[] args){
        Solution_64 solution = new Solution_64();
        System.out.println(solution.minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}

/**
 * DP思想，和62题类似，只是额外加了每个单元格存在值的合计。
 */
class Solution_64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    result[row - 1 - i][col - 1 - j] = grid[i][j];
                } else if (i == row - 1 && j < col - 1) {
                    result[row - 1 - i][col - 1 - j] = result[row - 1 - i][col - 1 - j - 1] + grid[i][j];
                } else if (i < row - 1 && j == col - 1) {
                    result[row - 1 - i][col - 1 - j] = result[row - 1 - i - 1][col - 1 - j] + grid[i][j];
                } else {
                    result[row - 1 - i][col - 1 - j] = Math.min(result[row - 1 - i][col - 1 - j - 1], result[row - 1 - i - 1][col - 1 - j])
                             + grid[i][j];
                }
            }
        }

        return result[row - 1][col - 1];
    }
}
