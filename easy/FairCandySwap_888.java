import java.util.HashSet;
import java.util.Set;

public class FairCandySwap_888 {
    public static void main(String[] args){
        Solution_888 solution = new Solution_888();
        int[] result = solution.fairCandySwap(new int[]{1,1}, new int[]{2,2});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

/**
 * 交换糖果
 */
class Solution_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        //result[0] - result[1] = sumSub
        int sumSub = (sumIntArray(A) - sumIntArray(B)) / 2;

        Set<Integer> setA = new HashSet<>();
        for (int i : A) {
            setA.add(i);
        }

        for (int j : B) {
            if (setA.contains(sumSub + j)) {
                return new int[]{sumSub + j, j};
            }
        }
        return new int[]{0, 0};
    }

    private int sumIntArray(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
