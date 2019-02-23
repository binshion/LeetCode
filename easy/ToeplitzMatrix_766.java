public class ToeplitzMatrix_766 {
    public static void main(String[] args) {
        Solution_766 solution = new Solution_766();
        System.out.println(solution.isToeplitzMatrix(new int[][]{{5,2,3,4},{5,1,2,3},{9,5,1,2}}));;
    }
}

/**
 * 计算矩阵的对角线方向的数据是否相同
 * 根据矩阵的宽高决定先运算三角形，然后梯形。大概率情况是在三角形区域找到了不符合的情况
 */
class Solution_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int length = matrix.length;
        int subLength = matrix[0].length;
        boolean result1 = true;
        boolean result2 = true;
        if (length - subLength > 1) {
            result1 = topleftToTopright(matrix, length, subLength);
            result2 = topleftToBottomleft(matrix, length, subLength);
        } else {
            result1 = topleftToBottomleft(matrix, length, subLength);
            result2 = topleftToTopright(matrix, length, subLength);
        }
        return result1 && result2;
    }

    boolean topleftToTopright(int[][] matrix, int length, int subLength) {
        for (int i = 1; i < subLength - 1; i++) {
            for (int m = 1, n = i + 1; m < length &&
                    n < subLength; m++, n++) {
                if (matrix[0][i] != matrix[m][n]) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean topleftToBottomleft(int[][] matrix, int length, int subLength) {
        for (int i = 0; i < length - 1; i++) {
            for (int m = i + 1, n = 1; m < length &&
                    n < subLength; m++, n++) {
                if (matrix[i][0] != matrix[m][n]) {
                    return false;
                }
            }
        }
        return true;
    }
}