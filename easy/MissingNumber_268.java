import java.util.Arrays;

public class MissingNumber_268 {
    public static void main(String[] args) {
        Solution_268 solution = new Solution_268();
        System.out.println(solution.missingNumber2(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(solution.missingNumber2(new int[]{1}));
    }
}

class Solution_268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != 0) {
                    return 0;
                }
            } else {
                if (nums[i] != nums[i - 1] + 1) {
                    return nums[i - 1] + 1;
                }
            }
        }
        return nums[nums.length - 1] +1;
    }

    /**
     * 不排序的话，时间复杂度可以控制在O(n)
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = -1;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != -1) {
                return i;
            }
        }
        return 0;
    }
}