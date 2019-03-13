import java.util.Arrays;

public class ContainsDuplicate_217 {
    public static void main(String[] args){
        Solution_217 solution = new Solution_217();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,1}));
    }
}

/**
 * 第一思路：排序再求相邻元素是否相同
 */
class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
