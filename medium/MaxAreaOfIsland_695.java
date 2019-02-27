public class MaxAreaOfIsland_695 {
    public static void main(String[] args){
        Solution_695 solution = new Solution_695();
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                                                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                                                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                                                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                                                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                                                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                                                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                                                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
}

/**
 * 类似迷宫，使用深度优先搜索
 */
class Solution_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        //左上右下
        int tempMax = 1;  //当前位置符合要求
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;  //将当前位置置为0，以免队规调用重复使用
        tempMax += dfs(grid, i, j - 1) + dfs(grid, i - 1, j) +
                dfs(grid, i , j + 1) + dfs(grid, i + 1, j);

        return tempMax;
    }
}
