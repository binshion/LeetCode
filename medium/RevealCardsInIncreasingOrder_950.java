import java.util.Arrays;
import java.util.LinkedList;

/**
 * 使用动态规划求解
 * 纸牌翻面排序问题
 */
public class RevealCardsInIncreasingOrder_950 {
    static class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);  //先排序
            int[][] result = new int[deck.length][];
            for (int i = 0; i < deck.length; i++) {
                int[] temp = new int[i + 1];

                if (i == 0) {
                    temp[i] = deck[deck.length - 1 - i];
                } else {
                    temp = moveLastToFirst(deck[deck.length - 1 - i], result[i - 1]);
                }
                result[i] = temp;
            }

            return result[deck.length - 1];
        }

        public int[] moveLastToFirst(int first, int[] needChange) {
            int[] newInt = new int[needChange.length +1];
            if (needChange.length == 1) {
                newInt[0] = first;
                newInt[1] = needChange[0];
                return newInt;
            } else {
                newInt[0] = first;
                newInt[1] = needChange[needChange.length - 1];
                for (int i = needChange.length - 2; i >= 0; i--) {
                    newInt[i + 2] = needChange[i];
                }
                return newInt;
            }
        }
    }

    public static void main(String[] args) {
        int[] deck = new int[]{17,13,11,2,3,5,7};
//        int[] deck = new int[]{5,7};
        deck = new Solution().deckRevealedIncreasing(deck);

        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i] + " ");
        }
    }
}
