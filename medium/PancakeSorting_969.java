import java.util.Arrays;
import java.util.List;

public class PancakeSorting_969 {
    public static void main(String[] args){
        Solution_969 solution = new Solution_969();
        solution.pancakeSort(new int[]{3, 2, 4, 1});
    }
}

/**
 * 思路
 */
class Solution_969 {
    public List<Integer> pancakeSort(int[] A) {
        int maxTarget = 0;
        int[] sorted = A.clone();
        Arrays.sort(sorted);
        for (int i = A.length; i > 0; i--) {
            maxTarget = sorted[i - 1];  //目标最大值
            if (maxTarget != A[i - 1]) {  //当目标值不在排序期待位置时
                //1.将目标最大值交换到数组首位


                //2.将首位的最大值交换到排序期待位置上
            }
        }
    }
}
