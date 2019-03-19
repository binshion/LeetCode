import java.util.ArrayList;
import java.util.List;

public class RLEIterator_900 {
    public RLEIterator(int[] A) {
        int size = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length / 2; i++) {
            if (A[2 * i] > 0 && (2 * i + 1) < A.length && A[2 * i + 1] >= 0) {
                for (int j = 0; j < A[2 * i]; j++) {
                    list.add(A[2 * i + 1]);
                }
            }
        }
    }

    public int next(int n) {

    }
}
