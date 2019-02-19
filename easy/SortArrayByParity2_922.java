import java.util.*;

public class SortArrayByParity2_922 {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = new int[]{4,1,1,0,1,0};
        a = solution.sortArrayByParityII(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}

/**
 * 大致思路：
 * 找出不符合的数据下标，偶数下标在链表前，奇数在后
 * 然后交换数据
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 0; i < length; i++) {
            if (i % 2 == 0 && A[i] % 2 == 1) {  //偶数下标放了奇数
                linkedList.addFirst(i);
            }
            if (i % 2 == 1 && A[i] % 2 == 0) {
                linkedList.addLast(i);
            }
        }

        if (linkedList.size() > 0) {
            int temp = 0;

            while (linkedList.size() > 0) {
                temp = A[linkedList.getFirst()];
                A[linkedList.removeFirst()] = A[linkedList.getLast()];
                A[linkedList.removeLast()] = temp;
            }
        }
        return A;
    }
}
