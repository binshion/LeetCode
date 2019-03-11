public class BeautifulArrangementII_667 {
    public static void main(String[] args) {
        Solution_667 solution = new Solution_667();
        int[] result = solution.constructArray(3, 1);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

/**
Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

If there are multiple answers, print any of them.

 Input: n = 3, k = 1
 Output: [1, 2, 3]
 Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.

 计算思路：
    所有差值可分为1，n - 1, n - 2, ... n - k + 1
 其中1放在首位，分别填充差值（从大到小），后面用差值为1的补齐
 e.g. n = 10, k = 4
 差值为1， 10 - 1， 10 - 2， 10 - 3
 则数组为1， 10， 2， 9， 8， 7， 6，5， 4， 3， 2
 分析得出先在奇数位填充1 和 3，偶数位填充 10 和 9 ，剩余元素倒序，找到最后一位为9， 倒序填充整个数组。
 k 为奇数同理，剩余元素顺序递增即可。
 */
class Solution_667 {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int min = 1;
        int max = n;
        int currentIndex = 0;
        for (int i = 0; i < k / 2; i++) {
            result[2 * i] = min++;
            result[2 * i + 1] = max--;
            if (i == k / 2 - 1) {
                currentIndex = 2 * i + 1 + 1;
            }
        }

        int current = 0;
        if (k % 2 == 0) {
            current = max;
            while (currentIndex < result.length) {
                result[currentIndex++] = current--;
            }
        } else {
            current = min;
            while (currentIndex < result.length) {
                result[currentIndex++] = current++;
            }
        }


        return result;
    }
}
