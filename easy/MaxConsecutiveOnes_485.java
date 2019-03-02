public class MaxConsecutiveOnes_485 {
    public static void main(String[] args) {
        Solution_485 solution = new Solution_485();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));

    }
}

class Solution_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }

        return Math.max(temp, max);
    }
}
