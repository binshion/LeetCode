import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray_448 {
    public static void main(String[] args){
        Solution_448 solution = new Solution_448();
        List<Integer> list = solution.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }
}

/**
 * 找出数组中未出现的所有元素
 * 数组元素满足：1 <= nums[i] <= nums.length;
 * 所有元素出现一次或两次
 */
class Solution_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] position = new int[nums.length];

        //申请一个数组，数组元素的下标和原始值一样
        //e.g. [1,2,2,3] -->[1,2,3,null]
        for (int i = 0; i < nums.length; i++) {
            position[nums[i] - 1] = nums[i];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            if (position[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
