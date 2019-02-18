import java.util.Arrays;

/**
 * 给定2n长度的数组，22分组，每组最小值得所有值集合的最大取值
 */
public class ArrayPartion1_561 {
    static class Solution {
        public int arrayPairSum(int[] nums) {
            if (nums.length == 2) {
                return nums[0] < nums[1] ? nums[0] : nums[1];
            }
            Arrays.sort(nums);

            int n = 0;
            int length = nums.length / 2;

            for (int i = 0; i < length; i++) {
                n += nums[i * 2];
            }
            return n;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int s = solution.arrayPairSum(new int[]{-1, 0, 1,2,3,4});
        System.out.println(s);
    }
}
