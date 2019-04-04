import java.util.ArrayList;
import java.util.List;

public class MinimumDominoRotationsForEqualRow_1007 {
    public static void main(String[] args){
        Solution_1007 solution = new Solution_1007();
        int[] a = new int[]{3,5,1,2,3};
        int[] b = new int[]{3,6,3,3,4};
        System.out.println(solution.minDominoRotations(a, b));
    }
}

/**
 * 将两个多米诺骨牌第一位数拿出当做候选值，候选值为1位或2位
 * 假定从A到B移动或B到A移动，分别记录需要移动次数，取最小值
 */
class Solution_1007 {
    public int minDominoRotations(int[] A, int[] B) {
        List<Integer> canditates = new ArrayList<>();
        canditates.add(A[0]);
        if (A[0] != B[0]) {
            canditates.add(B[0]);
        }

        int min = -1;
        for (int i = 0; i < canditates.size(); i++) {
            int candidate = canditates.get(i);
            int stepFromAtoB = 0;
            int stepFromBtoA = 0;
            if (canditates.size() > 1) {
                if (i == 0) {  //假定值在A处
                    stepFromAtoB++;
                } else {  //假定值在B处
                    stepFromBtoA++;
                }
            }

            for (int j = 1; j < A.length; j++) {
                if (candidate == A[j] && B[j] == A[j]) {
                    continue;
                } else if (candidate == A[j]) {
                    stepFromAtoB++;
                } else if (candidate == B[j]) {
                    stepFromBtoA++;
                } else {
                    stepFromAtoB = -1;
                    stepFromBtoA = -1;
                    break;
                }
            }

            if (stepFromAtoB == -1 && stepFromBtoA == -1) {
                continue;
            } else if (stepFromAtoB == -1 && stepFromBtoA >= 0) {
                if (min < 0) {
                    min = stepFromBtoA;
                } else {
                    min = Math.min(min, stepFromBtoA);
                }
            } else if (stepFromBtoA == -1 && stepFromAtoB >= 0) {
                if (min < 0) {
                    min = stepFromAtoB;
                } else {
                    min = Math.min(min, stepFromAtoB);
                }
            } else {
                if (min < 0) {
                    min = Math.min(stepFromBtoA, stepFromAtoB);
                } else {
                    min = Math.min(min, Math.min(stepFromBtoA, stepFromAtoB));
                }
            }
        }
        return min;
    }
}