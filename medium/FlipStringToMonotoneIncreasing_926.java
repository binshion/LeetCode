public class FlipStringToMonotoneIncreasing_926 {
    public static void main(String[] args){
        Solution_926 solution = new Solution_926();
//        System.out.println(solution.minFlipsMonoIncr("0101100011"));
//        System.out.println(solution.minFlipsMonoIncr("010110"));
//        System.out.println(solution.minFlipsMonoIncr("00011000"));
//        System.out.println(solution.minFlipsMonoIncr("00110111"));
//        System.out.println(solution.minFlipsMonoIncr("011010001101001"));
        System.out.println(solution.minFlipsMonoIncr("10011111110010111011"));

    }
}
//"100111111100101110   11"
//11111110010
/**
 * 大致思路：
 * 找到第一次出现1的位置，然后找到后面的数据出现1和出现0的个数：
 * 1.个数相同，这随意变换都行，最小变换为出现个数；
 * 2.出现1的个数大于0的个数，取0的个数；
 * 3.否则：出现 min(1个个数+ 1, 出现0的个数)
 */
class Solution_926 {
    public int minFlipsMonoIncr(String S) {
        int first = 0;
        int last = S.length() - 1;
        while (first <= last) {
            if (S.charAt(first) == '0') {
                first++;
            }
            if (S.charAt(last) == '1') {
                last--;
            }

            if (first >= S.length() || last < 0) {
                return 0;
            }

            if (S.charAt(first) == '1' && S.charAt(last) == '0') {
                break;
            }
        }

        S = S.substring(first, last + 1);

        int sizeOf0 = 0;
        int sizeOf1 = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                sizeOf1++;
            } else {
                sizeOf0++;
            }
        }

        int min = Math.min(sizeOf0, sizeOf1);

        //头1变0,尾0变 1 变化2次，再重复
        return 2 + minFlipsMonoIncr("0" + S.substring(1, S.length() - 1) + "1");
    }

    public int minFlipsMonoIncr2(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, P[j] + N-j-(P[N]-P[j]));
        }

        return ans;
    }
}
