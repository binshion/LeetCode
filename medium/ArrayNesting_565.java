import java.util.*;

public class ArrayNesting_565 {
    public static void main(String[] args) {
        Solution_565 solution = new Solution_565();
        System.out.println(solution.arrayNesting3(new int[]{5,4,0,3,1,6,2}));
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
        int tempMax = 0;
        int temp = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(i);
        }

        while (list.size() > 0) {
            start = list.get(0);
            temp = start;
            tempMax = 1;
            while (true) {
                list.remove((Integer)temp);
                if (nums[temp] != start) {
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

    public int arrayNesting3(int[] nums) {
        int max = 0;
        int tempMax = 0;
        int start = 0;
        boolean[] list = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!list[i]) {
                tempMax = 0;
                start = nums[i];

                do {
                    start = nums[start];
                    tempMax++;
                    list[start] = true;
                } while (nums[i] != start);

                max = Math.max(max, tempMax);
            }
        }
        return max;
    }
}
