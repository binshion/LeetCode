import java.util.Arrays;

/**
 * 计算数组能组成三角形的最大周长
 */
public class LargestPerimeterTriangle_976 {
    public static void main(String[] args) {
        Solution_976 solution = new Solution_976();
        System.out.println(solution.largestPerimeter(new int[]{1,2,1}));
    }
}

class Solution_976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
