import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequence_873 {
    public static void main(String[] args){
        Solution_873 solution = new Solution_873();
//        System.out.println(solution.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
        System.out.println(solution.lenLongestFibSubseq(new int[]{2,5,6,7,8,10,12,17,24,41,65}));
    }
}

class Solution_873 {
    /**
     * 暴力破解
     * @param A
     * @return
     */
    public int lenLongestFibSubseq2(int[] A) {
        int max = 0;
        for (int i = 0; i <= A.length - 3; i++) {
            for (int j = i + 1; j <= A.length - 2; j++) {
                if (A[i] + A[j] < A[j + 1]) {
                    max = Math.max(max, 0);
                    continue;
                }
                if (A[i] + A[j] > A[A.length - 1]) {
                    max = Math.max(max, 0);
                    break;
                }
                if (A.length + 1 - j <= max) {
                    continue;
                }
                max = Math.max(max, getMax(2, i, j, j + 1, A));
            }
        }
        return max;
    }

    private int getMax(int currentMax, int first, int second, int nextIndex, int[] a) {
        if (nextIndex == a.length) {
            return currentMax >= 3 ? currentMax : 0;
        }
        int next = a[first] + a[second];
        if (next < a[nextIndex] || next > a[a.length - 1]) {
            return currentMax >= 3 ? currentMax : 0;
        }

        int index = Arrays.binarySearch(a, nextIndex, a.length, next);
        if (index >= 0) {
            return getMax(currentMax + 1, second, index, index + 1, a);
        } else {
            return getMax(currentMax, first, second, nextIndex + 1, a);
        }
    }

    /**
     * 暴力求解可能造成超时，看别人的做法，查询过程使用hashSet更快
     * 而在递增数组中使用的二分查找
     * @param A
     * @return
     */
    public int lenLongestFibSubseq(int[] A) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }

        for (int i = 0; i <= A.length - 3; i++) {
            for (int j = i + 1; j <= A.length - 2; j++) {
                int currentMax = 2;
                int first = A[i];
                int second = A[j];
                int third = first + second;
                while (set.contains(third)) {
                    max = Math.max(max, ++currentMax);
                    first = second;
                    second = third;
                    third = first + second;
                }
            }
        }
        return max >= 3 ? max : 0;
    }
}
