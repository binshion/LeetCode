
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting_969 {
    public static void main(String[] args){
        Solution_969 solution = new Solution_969();
        List<Integer> list = solution.pancakeSort(new int[]{3,1,2});

        System.out.println(list.toString());
    }
}

/**
 * 思路
 */
class Solution_969 {
    public List<Integer> pancakeSort(int[] A) {
        int[] sorted = A.clone();
        Arrays.sort(sorted);
        List<Integer> result = new ArrayList<>();
        for (int i = sorted.length; i > 1; i--) {

            for (int j = i; j > 0; j--) {
                //当目标值不在排序期待位置时
                if (sorted[i - 1] == A[j - 1] && i != j) {
                    //1.将目标最大值交换到数组首位
                    if (j != 1) {  //j == 1已经在首位无需交换
                        result.add(j);
                        flip(A, (j - 1));  //反转数组，从0至第index个位置
                    }

                    //2.将首位的最大值交换到排序期待位置上
                    result.add(i);
                     //最后一次无需变化，已经生成了结果
                    if (i != 2) {
                        flip(A, i - 1);
                    }
                    break;
                }
            }
        }
        return result;
    }

    private void flip(int[] A, int fromIndex) {
        int temp = 0;
        for (int i = 0; i < (fromIndex + 1) / 2; i++) {
            temp = A[i];
            A[i] = A[fromIndex - i];
            A[fromIndex - i] = temp;
        }
    }
}
