import java.util.ArrayList;
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

class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    }
}
