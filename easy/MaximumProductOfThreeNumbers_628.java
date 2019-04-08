import java.util.Arrays;

public class MaximumProductOfThreeNumbers_628 {
    public static void main(String[] args){
        Solution_628 solution = new Solution_628();
        System.out.println(solution.maximumProduct(new int[]{-1,-2,1,2,3}));
    }
}

class Solution_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] >= 0 || nums[nums.length - 1] <= 0) {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }

        //剩下情况至少满足包含一个正数一个负数
        int lessThanZero = 0;
        int moreThanZero = 0;
        for (int i = 0; i < 3; i++) {
            if (nums[i] < 0) {
                lessThanZero++;
            } else {
                break;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (nums[nums.length - 1 - i] > 0) {
                moreThanZero++;
            } else {
                break;
            }
        }

        if (lessThanZero == 1 && moreThanZero == 1) {
            return 0;
        } else if (lessThanZero == 1 && moreThanZero >= 2) {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        } else if (lessThanZero >= 2 && moreThanZero == 1) {
            return nums[0] * nums[1] * nums[nums.length - 1];
        } else if (lessThanZero >= 2 && moreThanZero == 2) {
            return nums[0] * nums[1] * nums[nums.length - 1];
        } else {
            return nums[nums.length - 1] * (nums[0] * nums[1] > nums[nums.length - 3] * nums[nums.length - 2] ?
                                 nums[0] * nums[1] : nums[nums.length - 3] * nums[nums.length - 2]);
        }
    }
}