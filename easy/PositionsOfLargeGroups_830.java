import java.util.ArrayList;
import java.util.List;

/**
 * abcdddeeeeaabbbcd
 */
public class PositionsOfLargeGroups_830 {
    public static void main(String[] args) {
        Solution_830 solution = new Solution_830();
        List<List<Integer>> result = solution.largeGroupPositions("aaa");
        for (List list : result) {
            System.out.print(list.get(0) + ", " + list.get(1));
            System.out.println();
        }
    }
}

class Solution_830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List result = new ArrayList();
        int length = 1;
        char first = S.charAt(0);
        int start = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == first) {
                length++;
                if (i == S.length() - 1 && length >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i);
                    result.add(list);
                }
            } else {
                if (length >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i - 1);
                    result.add(list);
                }
                first = S.charAt(i);
                length = 1;
                start = i;
            }
        }

        return result;
    }
}
