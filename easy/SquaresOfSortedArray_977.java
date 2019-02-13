import java.util.Arrays;

public class SquaresOfSortedArray_977 {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] =(int)Math.pow(A[i], 2);
        }

        Arrays.sort(B);

        return B;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray_977 solution = new SquaresOfSortedArray_977();
        int[] b = solution.sortedSquares(new int[]{-3, -1, 0, 2, 4});
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
