public class MonotonicArray_896 {
    public static void main(String[] args){
        Solution_896 solution = new Solution_896();
        System.out.println(solution.isMonotonic(new int[]{1, 3, 2, 4}));
    }
}

class Solution_896 {
    public boolean isMonotonic(int[] A) {
        if (A.length < 3) {
            return true;
        }

        for (int i = 0; i < A.length / 2; i++) {
            if ((A[i] - A[i + 1]) >= 0 && (A[A.length / 2 + i] - A[A.length / 2 + i + 1]) >= 0) {
                continue;
            } else if ((A[i] - A[i + 1]) <= 0 && (A[A.length / 2 + i] - A[A.length / 2 + i + 1]) <= 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
