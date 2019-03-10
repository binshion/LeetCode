import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        Solution_78 solution = new Solution_78();
        List<List<Integer>> lists = solution.subsets(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 求数组的子集
 */
class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        lists.get(0).add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            List<List<Integer>> tempLists = new ArrayList<>();
            for (int j = 0; j < lists.size(); j++) {
                List<Integer> tempList = new ArrayList<>();
                for (int k = 0; k < lists.get(j).size(); k++) {
                    tempList.add(lists.get(j).get(k));
                }
                tempList.add(current);
                tempLists.add(tempList);
            }

            for (List<Integer> list : tempLists) {
                lists.add(list);
            }
        }
        return lists;
    }

}
