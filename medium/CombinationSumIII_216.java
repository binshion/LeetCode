import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    public static void main(String[] args) {
        Solution_216 solution = new Solution_216();
        List<List<Integer>> lists = solution.combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution_216 {
    /**
     * 使用动态规划思想：
     * 求k个之前的k - 1个数组成n剩余的值
     * @param k
     * @param n
     * @return
     */
    List<List<Integer>> results=new ArrayList<>();
    List<Integer> result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSearch(1,k,n);
        return results;
    }
    void combinationSearch(int start,int k,int n){
        if(k==0 && n==0)results.add(new ArrayList<>(result));
        if(k==0 || n==0)return;
        for(int i=start;i<=9;i++){
            result.add(i);
            combinationSearch(i+1,k-1,n-i);
            result.remove(result.size()-1);
        }
    }

}
