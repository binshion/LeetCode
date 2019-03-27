import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    public static void main(String[] args){
        Solution_39 solution = new Solution_39();
        int[] candidates = {2, 3, 6, 7};
        int target= 7;
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer number : list) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}

/**
 * DFS深度优先
 */
class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);

        getLists(lists, new ArrayList<Integer>(), candidates, target, 0);

        return lists;
    }

    private void getLists(List<List<Integer>> lists, List<Integer> cur, int[] candidates, int target, int startIndex) {
        if (target > 0) {
            for (int i = startIndex; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getLists(lists, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);  //回退最后一个  关键点
            }
        } else if (target == 0){
            lists.add(new ArrayList<Integer>(cur));
        }
    }
}
