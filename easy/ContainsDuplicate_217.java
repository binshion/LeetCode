import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    public static void main(String[] args){
        Solution_217 solution = new Solution_217();
        System.out.println(solution.containsDuplicate2(new int[]{1,2,3,1}));
    }
}

/**
 * 第一思路：排序再求相邻元素是否相同
 * 最好的思路：应该是使用set，set和数组长度不一样就有重复的
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

    //优解
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }
}
