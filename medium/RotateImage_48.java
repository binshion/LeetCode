public class RotateImage_48 {
    public static void main(String[] args){
        Solution_48 solution = new Solution_48();
        int[][] table = {{1,2,3}, {4,5,6}, {7,8,9}};
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

class Solution_48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int currentLength = matrix.length - 2 * i;
            int firstRow = i;
            int firstCol = i;
            int first = matrix[firstRow][firstCol];
            int next = 0;
            for (int j = i; j < i + currentLength - 1; j++) {
                next = matrix[firstCol][currentLength - 1 - firstRow];
                int tempRow = firstCol;
                int tempCol = currentLength - 1 - firstRow;
                firstRow = tempRow;
                firstCol = tempCol;
                matrix[firstRow][firstCol] = first;
                first = next;
            }
        }
    }
}
