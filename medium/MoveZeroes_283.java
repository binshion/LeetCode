import java.util.*;

public class MoveZeroes_283 {
    public static void main(String[] args){
        Solution_283 solution = new Solution_283();
        int[] nums = new int[]{2,1,0,3};
        solution.moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}

/**
 * 将数组中为0的元素移动到尾端，其他元素按原先位置放置
 */
class Solution_283 {
    public void moveZeroes(int[] nums) {
        int index = 0;  //记录当前需要处理的元素位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {  //非零数据
                if (i != index) {
                    nums[index] = nums[i];
                }
                index++;  //驱动当前位置向后移动
            }
        }

        //处理后面为0的情况
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
