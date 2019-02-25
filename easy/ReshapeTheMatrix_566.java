/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix_566 {
    public static void main(String[] args) {
        Solution_566 solution = new Solution_566();
        int[][] result = solution.matrixReshape(new int[][]{{1,2}, {3,4}}, 2, 4);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
    }
}

/**Example 1:
 * Input:
 * nums = [[1,2],[3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 *
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 *  [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 */
class Solution_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }

        int[][] result = new int[r][c];
        int beginRow = 0;
        int beginCol = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[beginRow][beginCol++];  //横向驱动
                if (beginCol == nums[0].length) {  //控制行号变化由列号来决定，纵向驱动
                    beginCol = 0;
                    beginRow += 1;
                }
            }
        }

        return result;
    }
}