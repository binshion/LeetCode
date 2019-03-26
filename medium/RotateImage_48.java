public class RotateImage_48 {
    public static void main(String[] args){
        Solution_48 solution = new Solution_48();
        int[][] table = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] table = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        solution.rotate(table);
        System.out.println("*******************");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 将n*n矩阵旋转90度。
 * 大体思路：
 * 1   2  3  4  5
 * 6   7  8  9 10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * 21 22 23 24 25
 * 1.每一圈的元素轮换一次，计算几圈（matrix.length / 2）
 * 2.针对每一圈，找一个起始点，需要转4次；下一个起始点往右移动一位，直到倒数第二位，如
 * 第一圈起始位1，依次交换1 5 25 21 1
 *       下一个起始位2，依次交换2 10 24 16 2
 *                  3          3 15 23 11 3
 *                  满足 下一个点的行等于上一个点的列
 *                       下一个点的列 + 上一个点的行 = 列最大值 - 1
 */
class Solution_48 {
    public void rotate(int[][] matrix) {
        int s = 0;
        for (int i = 0; i < matrix.length / 2; i++) {
            int currentLength = matrix.length - 2 * i;
            if (i == 0) {
                s = currentLength;
            }
            int firstRow = i;
            int firstCol = i;
            for (int k = 0; k < currentLength - 1; k++) {
                firstCol = i + k;
                firstRow = i;


                int first = matrix[firstRow][firstCol];
                int next = 0;
                for (int j = 0; j < 4; j++) {
                    int tempRow = firstCol;
                    int tempCol = s - 1 - firstRow;
                    next = matrix[tempRow][tempCol];
                    firstRow = tempRow;
                    firstCol = tempCol;
                    matrix[firstRow][firstCol] = first;
                    first = next;
                }
            }
        }
    }
}
