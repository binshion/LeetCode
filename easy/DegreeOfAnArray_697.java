import java.util.*;

public class DegreeOfAnArray_697 {
    public static void main(String[] args) {
        Solution_697 solution = new Solution_697();
        System.out.println(solution.findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}

class Solution_697 {
    public int findShortestSubArray(int[] nums) {
        //1.合成Map然后找出频率最大的Map信息。如果最大的存在多个，则需要比较
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                max = Math.max(max, map.get(nums[i]));
            } else {
                map.put(nums[i], 1);
            }
        }

        //如果每个元素都只出现一次，则最小数组长度为1
        if (max == 1) {
            return 1;
        }

        List<Integer> list = new ArrayList<>();  //出现最大频率的元素集合
        Set<Integer> set = map.keySet();  //所有元素集合
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        int min = nums.length;  //整个数组长度肯定能算作是subarray
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            int begin = -1;  //假定起始位置
            int end = 0;  //假定结束位置下标
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == value) {
                    if (begin == -1) {
                        begin = j;  //第一次出现时作为起始位置
                    } else {
                        end = j;  //其他时候出现算最后一次出现位置
                    }
                }
            }
            min = Math.min(min, end - begin + 1);
            if (min == 2) {  //长度为2时可退出循环，因为最小值最小为2
                break;
            }
        }

        return min;
    }
}
