public class MonotonicArray_896 {
    public static void main(String[] args){
        Solution_896 solution = new Solution_896();
        System.out.println(solution.isMonotonic2(new int[]{1,2,3,5,4}));
    }
}

class Solution_896 {
    public boolean isMonotonic(int[] A) {
        if (A.length < 3) {
            return true;
        }

        boolean first = true;
        if (A.length % 2 == 1) {  //数组个数为奇数
            //先检测是否递减
            for (int i = 0; i < A.length / 2; i++) {
                if ((A[i] - A[i + 1]) >= 0 && (A[A.length / 2 + i] - A[A.length / 2 + 1 + i]) >= 0) {
                    continue;
                } else {
                    first = false;
                    break;
                }
            }

            if (first) {  //如果递增，则直接返回
                return first;
            } else {  //如果不递增，则看是否递减
                for (int i = 0; i < A.length / 2; i++) {
                    if ((A[i] - A[i + 1]) <= 0 && (A[A.length / 2 + i] - A[A.length / 2 + 1 + i]) <= 0) {
                        first = true;
                    } else {
                        return false;  //不递减，则返回
                    }
                }

                return first;
            }
        } else {  //数组个数为偶数
            for (int i = 0; i < A.length / 2 - 1; i++) {
                if ((A[i] - A[i + 1]) >= 0 &&  (A[A.length / 2 + i] - A[A.length / 2 + 1 + i]) >= 0) {
                    continue;
                } else {
                    first = false;
                    break;
                }
            }
            if ((A[A.length / 2 - 1] - A[A.length / 2]) >= 0 && first) {
                return true;
            } else {
                first = false;
            }

            //检测是否递增
            first = true;
            for (int i = 0; i < A.length / 2 - 1; i++) {
                if ((A[i] - A[i + 1]) <= 0 &&  (A[A.length / 2 + i] - A[A.length / 2 + 1 + i]) <= 0) {
                    continue;
                } else {
                    return false;
                }
            }

            if ((A[A.length / 2 - 1] - A[A.length / 2]) <= 0 && first) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isMonotonic2(int[] A) {
        int flag = 0;
        for (int i = 1; i < A.length; i++) {
            if ((A[i] - A[i - 1]) == 0) {
                continue;
            } else if ((A[i] - A[i - 1]) > 0 && flag == 0) {  //递增
                flag = 1;  //设置递增标记
            } else if ((A[i] - A[i - 1]) < 0 && flag == 0){
                flag = -1;  //设置递减标记
            }

            if (flag == 1 && (A[i] - A[i - 1]) < 0) {
                return false;
            }
            if (flag == -1 && (A[i] - A[i - 1]) > 0) {
                return false;
            }
        }

        return true;
    }
}
