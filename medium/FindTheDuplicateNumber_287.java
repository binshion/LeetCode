public class FindTheDuplicateNumber_287 {
    public static void main(String[] args){
        Solution_287 solution = new Solution_287();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}

class Solution_287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
