import java.util.ArrayList;
import java.util.Arrays;

public class SquaresOfSortedArray_977 {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] =(int)Math.pow(A[i], 2);
        }

        Arrays.sort(B);

        return B;
    }

    /**
    使用归并排序
     */
    public int[] sortedSquares2(int[] A) {
        if (A.length < 1) {
            return null;
        } else if (A.length == 1) {
            int[] B = new int[]{(int) Math.pow(A[0], 2)};
            return B;
        } else {  //数组中是否存在0的数，且是否存在跨正负的
            int first = A[0];  //第一个
            int last = A[A.length - 1];  //最后一个

            if (first >= 0) {
                int[] B = new int[A.length];
                for (int i = 0; i < A.length; i++) {
                    B[i] = (int) Math.pow(A[i], 2);
                }

                return B;
            } else if (last <= 0) {
                int[] B = new int[A.length];
                for (int i = 0; i < A.length; i++) {
                    B[i] = (int) Math.pow(A[A.length - i - 1], 2);
                }

                return B;
            } else {  //归并排序
                int indexOfMoreThanZero = 0;
                for (int i = 0; i < A.length; i++) {
                    if(A[i] >= 0) {
                        indexOfMoreThanZero = i;
                        break;
                    }
                }

                int[] lessThanZero = new int[indexOfMoreThanZero];
                int[] moreThanZero = new int[A.length - lessThanZero.length];
                for (int i = 0; i < lessThanZero.length; i++) {
                    lessThanZero[i] = (int) Math.pow(A[lessThanZero.length - i - 1], 2);
                }

                for (int i = lessThanZero.length; i < A.length; i++) {
                    moreThanZero[i - lessThanZero.length] = (int) Math.pow(A[i], 2);
                }

                int[] retArray = new int[A.length];

                int indexOfret = 0;  //返回构建数组的当前元素索引
                int indexOfLess = 0;  //小于0的数组索引
                int indexOfMore = 0;  //大于0的数组索引
                while (indexOfret < retArray.length) {
                    while (indexOfLess < lessThanZero.length && indexOfMore < moreThanZero.length) {
                        if(lessThanZero[indexOfLess] <= moreThanZero[indexOfMore]) {
                            retArray[indexOfret++] = lessThanZero[indexOfLess++];
                        } else {
                            retArray[indexOfret++] = moreThanZero[indexOfMore++];
                        }
                    }

                    //小于0的列表取完了，直接将大于0的列表剩余元素全部按次序放入
                    if (indexOfLess == lessThanZero.length && indexOfMore < moreThanZero.length) {
                        while (indexOfMore < moreThanZero.length) {
                            retArray[indexOfret++] = moreThanZero[indexOfMore++];
                        }
                    }

                    //大于0的列表取完了，直接将小于0的列表剩余元素全部按次序放入
                    if (indexOfMore == moreThanZero.length && indexOfLess < lessThanZero.length) {
                        while (indexOfLess < lessThanZero.length) {
                            retArray[indexOfret++] = lessThanZero[indexOfLess++];
                        }
                    }
                }

                return retArray;
            }
        }
    }

    public static void main(String[] args) {
        SquaresOfSortedArray_977 solution = new SquaresOfSortedArray_977();
        int[] b = solution.sortedSquares2(new int[]{-1,2,2});
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
