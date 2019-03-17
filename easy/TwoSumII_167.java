import java.util.Arrays;

public class TwoSumII_167 {
    public static void main(String[] args) {
        Solution_167 solution = new Solution_167();
//        int[] result = solution.twoSum(new int[]{1,2,3,4,4,9,56,90}, 8);

        int[] result = solution.twoSum(new int[]{-1,0}, -1);
//        int[] result = solution.twoSum(new int[]{2,3,4}, 6);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int first = numbers[i];
            int second = target - first;
            if (second < first) {
                break;
            }

            int indexOfSecond = Arrays.binarySearch(numbers, i + 1, numbers.length, second);
            if (indexOfSecond > 0) {
                return new int[]{i + 1, indexOfSecond + 1};
            }
        }

        return null;
    }
}