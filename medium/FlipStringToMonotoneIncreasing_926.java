public class FlipStringToMonotoneIncreasing_926 {
    public static void main(String[] args){
        Solution_926 solution = new Solution_926();
//        System.out.println(solution.minFlipsMonoIncr("0101100011"));
//        System.out.println(solution.minFlipsMonoIncr("010110"));
//        System.out.println(solution.minFlipsMonoIncr("00011000"));
//        System.out.println(solution.minFlipsMonoIncr("00110111"));
        System.out.println(solution.minFlipsMonoIncr("011010001101001"));
    }
}

/**
 * 大致思路：
 * 找到第一次出现1的位置，然后找到后面的数据出现1和出现0的个数：
 * 1.个数相同，这随意变换都行，最小变换为出现个数；
 * 2.出现1的个数大于0的个数，取0的个数；
 * 3.否则：出现 min(1个个数+ 1, 出现0的个数)
 */
class Solution_926 {
    public int minFlipsMonoIncr(String S) {
        int index = S.indexOf("1");

        //1出现的位置在最后一位或没有1，则不需要翻转，原String就是单调递增
        if (index == S.length() - 1 || index < 0) {
            return 0;
        }

        //1之后的子串
        int sizeOf0 = 0;
        int sizeOf1 = 0;
        for (int i = index + 1; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                sizeOf1++;
            } else {
                sizeOf0++;
            }
        }

        if (sizeOf0 == sizeOf1) {
            //可以假定首次出现的1直接设为0，然后比较后面的数据
            return getJiaShe(1, S, index);
        } else if (sizeOf1 > sizeOf0) {
            return sizeOf0;
        } else {
            return Math.min(sizeOf0, sizeOf1 + 1);
        }
    }

    /**
     *
     * @param jiasheSize 假定由1变0 的次数
     * @param s
     * @param index 上次出现1的位置
     * @return
     */
    private int getJiaShe(int jiasheSize, String s, int index) {
        int nextIndex = s.indexOf("1", index + 1);

        int sizeOf0 = 0;
        int sizeOf1 = 0;
        for (int i = nextIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sizeOf1++;
            } else {
                sizeOf0++;
            }
        }

        if (sizeOf1 == sizeOf0) {
            return getJiaShe(jiasheSize + 1, s, nextIndex);
        } else if (sizeOf0 + sizeOf1 == 1) {
                return jiasheSize;
        } else {
            return Math.min(sizeOf1 + jiasheSize, sizeOf0);
        }
    }
}
