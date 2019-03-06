import java.util.*;

public class ArrayNesting_565 {
    public static void main(String[] args) {
        Solution_565 solution = new Solution_565();
        System.out.println(solution.arrayNesting2(new int[]{5,4,0,3,1,6,2}));
    }
}

class Solution_565 {
    public int arrayNesting(int[] nums) {
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = i;
            int tempMax = 1;
            while (true) {
                if (nums[temp] != i) {
                    tempMax++;
                    temp = nums[temp];
                } else {
                    break;
                }
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }

    public int arrayNesting2(int[] nums) {
        int max = 1;
        int tempMax = 1;
        int count = 0;
        while (count <= nums.length) {

        }
        return max;
    }
}
