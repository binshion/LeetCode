public class MaxChunksToMakeSorted_769 {
    public static void main(String[] args){
        Solution_769 solution = new Solution_769();
        System.out.println(solution.maxChunksToSorted(new int[]{5,2,7,4,0,6,3,1,8}));
    }
}

class Solution_769 {
    public int maxChunksToSorted(int[] arr) {
        int min = 0;

        int beginIndex = 0;
        int endIndex = getIndexOfValue(arr, min);
        int result = 0;
        int max = getMax(arr, beginIndex, endIndex);
        int currentSize = endIndex - beginIndex + 1;
        if (currentSize == arr.length) {
            return 1;
        }

        do {
            if (currentSize == max - min + 1) {
                result++;
                beginIndex = endIndex + 1;
                if (beginIndex == arr.length) {
                    break;
                }
                min = max + 1;
                endIndex = getIndexOfValue(arr, min);
                max = getMax(arr, beginIndex, endIndex);
                currentSize = endIndex - beginIndex + 1;
            } else if(currentSize < max - min + 1) {
                endIndex++;
                max = Math.max(max, arr[endIndex]);
                currentSize = endIndex - beginIndex + 1;
            } else {
                max = getMax(arr, beginIndex, endIndex);
            }
        } while (endIndex < arr.length);

        return result;
    }

    private int getMax(int[] arr, int beginIndex, int endIndex) {
        int max = 0;
        while (beginIndex <= endIndex) {
            max = Math.max(max, arr[beginIndex++]);
        }
        return max;
    }

    private int getIndexOfValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
