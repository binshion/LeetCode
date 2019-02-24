import java.util.*;

public class FindAllDuplicatesInAnArray_442 {
    public static void main(String[] args) {
        Solution_442 solution = new Solution_442();
        List<Integer> result = solution.findDuplicates3(new int[]{4, 3,2,7,8,2,3,1});

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}

class Solution_442 {
    /**
     * 使用字典记录次数
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);

                if (map.get(nums[i]) == 2) {
                    result.add(nums[i]);
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return result;
    }

    /**
     * 排序后左右相邻的是否相等
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                result.add(nums[i]);
            }
        }

        return result;
    }

    public List<Integer> findDuplicates3(int[] nums) {
        int[] a = new int[nums.length];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (a[nums[i] - 1] != -1) {
                a[nums[i] - 1] = -1;
            } else {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
