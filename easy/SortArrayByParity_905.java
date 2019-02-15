/**
 * 按奇偶顺序排序，偶数在前即可
 * Given an array A of non-negative integers,
 * return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 */
public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] A) {
        if (A.length < 2) {
            return A;
        } else {
            int leftIndex = 0;  //左侧开始
            int rightIndex = A.length - 1;  //右侧开始
            int temp;
            while (leftIndex < rightIndex) {
                //从右侧开始搜索第一个偶数的下标
                while (A[rightIndex] % 2 == 1 && rightIndex > 0) {
                    rightIndex--;
                }

                //从左侧开始搜索第一个奇数的下标
                while (A[leftIndex] % 2 == 0 && leftIndex < (A.length - 1)) {
                    leftIndex++;
                }

                //存在奇数在左侧且偶数在右侧则调换
                if(leftIndex < rightIndex) {
                    temp = A[leftIndex];
                    A[leftIndex] = A[rightIndex];
                    A[rightIndex] = temp;
                }
            }

            return A;
        }
    }

    public static void main(String[] args) {
        SortArrayByParity_905 solution = new SortArrayByParity_905();
        int[] a = new int[]{0,2};
        a = solution.sortArrayByParity(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
