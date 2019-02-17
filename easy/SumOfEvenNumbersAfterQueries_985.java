/**
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 */
public class SumOfEvenNumbersAfterQueries_985 {
    /**
     * 思路：
     *先对原来数组偶数求和，然后增对更改的具体元素做处理
     *原来数据为奇数：+ 奇数： sum + 原数 + 新
     *               + 偶数： sum 不变
     *原来数据为偶数：+ 奇数： sum - 原数
     *               + 偶数： sum + 新
     */
    static class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int sum = sumOfEvenNumber(A);  //开始的和
            int[] result = new int[queries.length];

            int origin = 0;
            for (int i = 0; i < queries.length; i++) {
                origin = A[queries[i][1]];
                A[queries[i][1]] += queries[i][0];
                if (origin % 2 != 0) {
                    if (queries[i][0] % 2 != 0) {
                        sum = sum + origin + queries[i][0];
                    }
                } else {
                    if (queries[i][0] % 2 != 0) {
                        sum -= origin;
                    } else {
                        sum += queries[i][0];
                    }
                }

                result[i] = sum;
            }
            return result;
        }

        public int sumOfEvenNumber(int[] A) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 == 0) {
                    sum += A[i];
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        A = new Solution().sumEvenAfterQueries(A, queries);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
