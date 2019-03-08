import java.util.Arrays;

public class MajorityElement_169 {
    public static void main(String[] args){
        Solution_169 solution = new Solution_169();
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}

class Solution_169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
