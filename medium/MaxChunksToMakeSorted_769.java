public class MaxChunksToMakeSorted_769 {
    public static void main(String[] args){
        Solution_769 solution = new Solution_769();
        System.out.println(solution.maxChunksToSorted(new int[]{5,2,7,4,0,6,3,1,8}));
    }
}

/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
    What is the most number of chunks we could have made?

 Input: arr = [4,3,2,1,0]
 Output: 1
 Explanation:
 Splitting into two or more chunks will not return the required result.
 For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 */
class Solution_769 {
    /**
     * 大体思路：首次设定最小值为0，找到最小值min的位置设定为chunks结束位置，起始位置0到结束位置的最大值max求解。
     *          如果chunks中的max - min + 1 == chunks.endIndex - chunks.beginIndex + 1,则形成一个thunks;
     *          如果max - min + 1 > chunks.endIndex - chunks.beginIndex + 1说明chunks容量不够，endindex++，
     *                  max可能变化
     *          否则说明max计算有误，重新计算一次最大值，重新求解下beginIndex到endIndex之间的最大值
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int min = 0;  //首个chunks中的最小值
        int beginIndex = 0;  //首个chunks相对arr的起始位置下标
        int endIndex = getIndexOfValue(arr, min);  //chunks相对arr的结束位置下标
        int result = 0;  //chunks的个数
        int max = getMax(arr, beginIndex, endIndex);  //chunks起始位置到结束位置间的最大值
        int currentSize = endIndex - beginIndex + 1;  //chunks的容量
        if (currentSize == arr.length) {  //首次计算的chunks容量为数组容量时，说明为一个chunks，不在计算
            return 1;
        }

        do {
            if (currentSize == max - min + 1) {  //chunks容量和最大最小值的差相等，说明可以合成一个chunks
                result++;
                beginIndex = endIndex + 1;  //下一个chunks的起始下标为上一个chunks的结束下标递增1
                if (beginIndex == arr.length) {
                    break;
                }
                min = max + 1;  //下一个chunks的最小值为上一个chunks的最大值递增1
                endIndex = getIndexOfValue(arr, min);  //假定chunks的最小值所在位置为当前chunks的结束位置
                max = getMax(arr, beginIndex, endIndex);  //重新获取该chunks区间的最大值
                currentSize = endIndex - beginIndex + 1;  //重新计算容量
            } else if(currentSize < max - min + 1) {  //chunks的容量比最大最小值差还小，则需要扩容
                endIndex++;
                max = Math.max(max, arr[endIndex]);
                currentSize = endIndex - beginIndex + 1;
            } else {  //chunks的容量比最大最小值差还大，则说明计算的最大值比区间实际存在的最大值小，重新计算
                max = getMax(arr, beginIndex, endIndex);
            }
        } while (endIndex < arr.length);

        return result;
    }

    /**
     * 返回给定数组下标范围的最大值
     * @param arr
     * @param beginIndex
     * @param endIndex
     * @return 给定数组下标范围的最大值
     */
    private int getMax(int[] arr, int beginIndex, int endIndex) {
        int max = 0;
        while (beginIndex <= endIndex) {
            max = Math.max(max, arr[beginIndex++]);
        }
        return max;
    }

    /**
     *
     * @param arr
     * @param value
     * @return 给定数组，给定值并求该值所在的下标index
     */
    private int getIndexOfValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
