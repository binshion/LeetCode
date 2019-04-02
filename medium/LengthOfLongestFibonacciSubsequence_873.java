import java.util.Arrays;

public class LengthOfLongestFibonacciSubsequence_873 {
    public static void main(String[] args){
        Solution_873 solution = new Solution_873();
        System.out.println(solution.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
}

class Solution_873 {
    /**
     * 暴力破解
     * @param A
     * @return
     */
    public int lenLongestFibSubseq(int[] A) {
        int max = 0;
        for (int i = 0; i <= A.length - 3; i++) {
            int first = A[i];
            for (int j = i + 1; j <= A.length - 2; j++) {
                int second = A[j];
                int third = A[j + 1];
                if (first + second < third) {
                    max = Math.max(max, 0);
                    continue;
                }
                if (first + second > A[A.length - 1]) {
                    max = Math.max(max, 0);
                    break;
                }
                max = Math.max(max, getMax(2, first, second, j + 1, A));
            }
        }
        return max;
    }

    private int getMax(int currentMax, int first, int second, int nextIndex, int[] a) {
        if (nextIndex == a.length) {
            return currentMax >= 3 ? currentMax : 0;
        }
        int next = first + second;
        if (next < a[nextIndex] || next > a[a.length - 1]) {
            return currentMax >= 3 ? currentMax : 0;
        }

        int index = Arrays.binarySearch(a, nextIndex, a.length, next);
        if (index >= 0) {
            return getMax(currentMax + 1, second, next, index + 1, a);
        } else {
            return getMax(currentMax, first, second, nextIndex + 1, a);
        }
    }
}
